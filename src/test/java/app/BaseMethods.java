package app;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

public class BaseMethods extends PageBuilders {
    private Browser browser;
    protected Page page;
    private BrowserContext context;
    private Boolean isTraceEnabled = false;


    @BeforeClass
    public void setUp()
    {
        String[] args = {"--start-maximized"};

        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setArgs(Arrays.asList(args))
                        .setHeadless(false)
                        .setChannel("chrome"));

        context = browser.newContext();

        // Трейсинг
        if(isTraceEnabled)
        {
            context.tracing().start(new Tracing.StartOptions()
                    .setSnapshots(true)
                    .setScreenshots(true)
                    .setSources(false));
        }
        // Новая страница
        page = context.newPage();
    }

    @AfterClass
    public void teardown() // Закрытие браузера
    {
        if (browser != null)
        {
            browser.close();
            browser=null;
        }
    }

    /** Методы для отчетности аллюра
     * Прикрепляем скриншоты, код страницы, трейсинг к упавшему тесту**/

    @AfterMethod
    public void fileAttachToFieldTest(ITestResult result) throws IOException {
        String uuid = null;
        byte[] screenshot = new byte[0];
        if (!result.isSuccess()) {
            uuid = UUID.randomUUID().toString();
            screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("build/allure-results/screenshot-" + uuid + "-srsht.png")) // Название скриншота с его уникальным юид
                    .setFullPage(true));
        }

        Allure.addAttachment(uuid, new ByteArrayInputStream(screenshot));
        Allure.addAttachment("source.html", "text/html", page.content());


        if(isTraceEnabled)
        {
            String traceFileName = String.format("build/%s_trace.zip", uuid);
            Path tracePath = Paths.get(traceFileName);
            context.tracing()
                    .stop(new Tracing.StopOptions()
                            .setPath(tracePath));
            Allure.addAttachment("trace.zip", new ByteArrayInputStream(Files.readAllBytes(tracePath)));
        }

    }

}

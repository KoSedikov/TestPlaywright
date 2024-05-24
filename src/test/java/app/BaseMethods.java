package app;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class BaseMethods extends PageBuilders {

    private Browser browser;
    protected Page page;
    private BrowserContext context;
    private final Boolean isTraceEnabled = false;

    @BeforeClass
    public void setUp()
    {

        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(getWeight(), getHeight()));

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

//    public static <T> boolean compareTwoValues(final T expected, final T actual, final String message)
//    {
//        if(actual == expected)
//        {
//            Allure.getLifecycle().getCurrentTestCaseOrStep().
//        }
//    }

    private int getWeight()
    {
        return (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }

    private int getHeight()
    {
        return (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

}

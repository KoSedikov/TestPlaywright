package pageSteps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageElements.NewsPageElements;

public class NewsPageSteps extends NewsPageElements {


    @Step
    public void checkNewsPageTitle(Page page)
    {
        String textContent;

        textContent = page.locator(TITLE_SELECTOR).textContent();
        Assert.assertEquals(textContent, NEWS_HEADER);
    }

}

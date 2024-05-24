package pageSteps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import pageElements.MainPageElements;

public class MainPageSteps extends MainPageElements {


    @Step
    public void headerLink(Page page, String linkName) {

        String link = String.format(MAIN_HEADER_LINK, linkName);

        page
                .locator(link)
                .click();

    }

    @Step
    public void checkPageByHeaderLink(){

    }
}

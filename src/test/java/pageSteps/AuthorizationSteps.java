package pageSteps;

import app.BaseMethods;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import pageElements.AuthorizationPageElements;

public class AuthorizationSteps extends BaseMethods {


    @Step
    public void goToMainPage(Page page)
    {
        page.navigate(AuthorizationPageElements.baseUrl);
    }

}

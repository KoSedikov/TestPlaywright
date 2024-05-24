package pageSteps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import pageElements.AuthorizationPageElements;

public class AuthorizationSteps extends AuthorizationPageElements {


    @Step
    @DisplayName("Переход на главную страницу")
    public void goToMainPage(Page page)
    {
        page.navigate(AuthorizationPageElements.MAIN_URL);
    }

}

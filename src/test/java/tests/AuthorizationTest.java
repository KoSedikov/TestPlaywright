package tests;

import app.BaseMethods;
import io.qameta.allure.junit4.DisplayName;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseMethods {

    @Test
    @DisplayName("Тест перехода на главную страницу")
    public void authTest()
    {
        authorization()
                .goToMainPage(this.page);
    }

    @Test
    @DisplayName("Тест регистрации нового пользователя")
    public void registerTest()
    {

    }

    @Test
    @DisplayName("Тест входа в учетную запись пользователя")
    public void loginTest()
    {

    }

    @Test
    @DisplayName("Тест сброса пароля пользователя")
    public void restPasswordTest()
    {

    }
}

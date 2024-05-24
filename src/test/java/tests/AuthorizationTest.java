package tests;

import app.BaseMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseMethods {

    @Test
    @Description("Тест перехода на главную страницу")
    public void authTest()
    {
        authorization()
                .goToMainPage(this.page);
    }

    @Test
    @Description("Тест регистрации нового пользователя")
    public void registerTest()
    {

    }

    @Test
    @Description("Тест входа в учетную запись пользователя")
    public void loginTest()
    {

    }

    @Test
    @Description("Тест сброса пароля пользователя")
    public void restPasswordTest()
    {

    }
}

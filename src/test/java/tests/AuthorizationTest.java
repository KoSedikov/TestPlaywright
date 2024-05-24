package tests;

import app.BaseMethods;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseMethods {

    @Test
    public void authTest()
    {
        authorization()
                .goToMainPage(this.page);
    }
}

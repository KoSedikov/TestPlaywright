package tests;

import app.BaseMethods;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pageElements.MainPageElements.NEWS;

public class NewsPageTests extends BaseMethods {

    @BeforeMethod
    public void authorize()
    {
        authorization()
                .goToMainPage(this.page);

    }

    @Test
    @Description("Проверка статей в разделе Новости")
    public void checkNewsPage()
    {
        mainPage()
                .headerLink(this.page, NEWS);
        newsPage()
                .checkNewsPageTitle(this.page);
    }

    @Test
    @Description("Проверка статей в разделе Новости")
    public void checkArticlesTest(){}

}

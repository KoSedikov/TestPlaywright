package tests;

import app.BaseMethods;
import io.qameta.allure.junit4.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pageElements.MainPageElements.*;

public class MainPageTests extends BaseMethods {


    @BeforeMethod
    public void authorize()
    {
        authorization()
                .goToMainPage(this.page);

    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+MAIN+"\"")
    public void checkMainHeaderLink()
    {
        mainPage().headerLink(this.page, MAIN);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+NEWS+"\"")
    public void checkNewsHeaderLink()
    {
        mainPage().headerLink(this.page, NEWS);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+DEPARTMENTS+"\"")
    public void checkDepartmentsHeaderLink()
    {
        mainPage().headerLink(this.page, DEPARTMENTS);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+QUESTION+"\"")
    public void checkQuestionHeaderLink()
    {
        mainPage().headerLink(this.page, QUESTION);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+GALLERY+"\"")
    public void checkGalleryHeaderLink()
    {
        mainPage().headerLink(this.page, GALLERY);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+CONTACTS+"\"")
    public void checkContactsHeaderLink()
    {
        mainPage().headerLink(this.page, CONTACTS);
    }

    @Test
    @DisplayName("Проверка присутствия ссылок перехода на главной странице  \""+PARTNERS+"\"")
    public void checkPartnersHeaderLink()
    {
        mainPage().headerLink(this.page, PARTNERS);
    }

}

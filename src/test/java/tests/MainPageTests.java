package tests;

import app.BaseMethods;
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
    public void checkMainHeaderLink()
    {
        mainPage().headerLink(this.page, MAIN);
    }

    @Test
    public void checkNewsHeaderLink()
    {

    }

    @Test
    public void checkDepartmentsHeaderLink()
    {

    }

    @Test
    public void checkQuestionHeaderLink()
    {

    }

    @Test
    public void checkGalleryHeaderLink()
    {

    }

    @Test
    public void checkContactsHeaderLink()
    {

    }
}

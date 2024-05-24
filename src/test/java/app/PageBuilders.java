package app;


import pageSteps.AuthorizationSteps;
import pageSteps.MainPageSteps;

public class PageBuilders {

    public MainPageSteps mainPage(){return new MainPageSteps();}

    public AuthorizationSteps authorization() {return new AuthorizationSteps();}

}

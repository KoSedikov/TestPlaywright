package app;


import pageSteps.AuthorizationSteps;
import pageSteps.BasePageSteps;
import pageSteps.MainPageSteps;
import pageSteps.NewsPageSteps;

public class PageBuilders {

    public MainPageSteps mainPage(){return new MainPageSteps();}
    public AuthorizationSteps authorization() {return new AuthorizationSteps();}
    public NewsPageSteps newsPage(){return new NewsPageSteps();}
    public BasePageSteps basePage(){return new BasePageSteps();}
}

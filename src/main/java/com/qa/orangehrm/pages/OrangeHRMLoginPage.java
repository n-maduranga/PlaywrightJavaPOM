package com.qa.orangehrm.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehrm.factory.PlaywrightFactory;

import java.util.Properties;

public class OrangeHRMLoginPage extends PlaywrightFactory {


    private Page page;

    //1.String Locators:
    private String txtUserName = "input[name='username']";
    private String txtPassword = "input[name='password']";
    private String btnLogin = "button[type='submit']";
    private String linkForgotPW = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p";

    //2.Page Constructor
    public OrangeHRMLoginPage(Page page){
        this.page = page;
    }

    //3.Page Actions
    public String getPageTitle(){
        return page.title();
    }

    public boolean isForgotPWLinkExist(){
        return page.isVisible(linkForgotPW);
    }

    public OrangeHRMHomePage appLogin(String username, String password)
    {

        page.fill(txtUserName,username);
        page.fill(txtPassword,password);
        page.click(btnLogin);
        page.waitForTimeout(3000);
        return new OrangeHRMHomePage(page);
    }



}

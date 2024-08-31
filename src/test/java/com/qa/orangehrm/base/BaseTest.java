package com.qa.orangehrm.base;
import com.qa.orangehrm.pages.*;
import com.microsoft.playwright.Page;
import com.qa.orangehrm.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pft;
    Page page;
    protected Properties prop;
    //Creating Page References
    protected OrangeHRMHomePage homePage;
    protected OrangeHRMLoginPage loginPage;
    protected OrangeHRMPIMPage pimPage;
    protected OrangeHRMAddEmpPage addEmpPage;
    protected OrangeHRMPersonalDetPage personalDetPage;

    @Parameters({"browser"})// need to give exact param name :with testng.xml
    @BeforeTest
    public void systemSetup(String browserName){
        pft = new PlaywrightFactory();
        prop = pft.initializeProperty();
        if(browserName!=null){
            prop.setProperty("browser",browserName); //here,set the browser property key :value of config file value
            //using testng.xml file(ignoring what prev set in config file
        }
        page= pft.initializeBrowser(prop); //passing property reference enables to load all the prop details at once
        loginPage = new OrangeHRMLoginPage(page);
       // homePage = new OrangeHRMHomePage(page);// this is created appLogin method (new OrangeHRMHomePage(page));
    }

    /*
    Without property file browser value we can set like this
    Here we pass the browser value to initializeBrowser method ,so it can take this as param
     */
   /*
   public void systemSetup(String browser){
        pft = new PlaywrightFactory();
        prop = pft.initializeProperty();
        page= pft.initializeBrowser(prop,browser); //passing property reference enables to load all the prop details at once
        loginPage = new OrangeHRMLoginPage(page);
        homePage = new OrangeHRMHomePage(page);
    }
    */
    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }


}

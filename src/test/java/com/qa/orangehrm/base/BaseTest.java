package com.qa.orangehrm.base;
import  com.qa.orangehrm.pages.OrangeHRMHomePage;
import com.microsoft.playwright.Page;
import com.qa.orangehrm.factory.PlaywrightFactory;
import com.qa.orangehrm.pages.OrangeHRMLoginPage;
import com.qa.orangehrm.pages.OrangeHRMPIMPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pft;
    Page page;
    protected Properties prop;
    //Creating Page References
    protected OrangeHRMHomePage homePage;
    protected OrangeHRMLoginPage loginPage;
    protected OrangeHRMPIMPage pimPage;

    @BeforeTest
    public void systemSetup(){
        pft = new PlaywrightFactory();
        prop = pft.initializeProperty();
        page= pft.initializeBrowser(prop);
        loginPage = new OrangeHRMLoginPage(page);
        homePage = new OrangeHRMHomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }


}

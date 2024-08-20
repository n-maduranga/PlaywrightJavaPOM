package com.qa.orangehrm.tests;

import com.qa.orangehrm.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifySuccessLogin(){
        homePage =loginPage.appLogin("Admin","admin123");
       boolean label= homePage.verifyDashboardLabel();
        Assert.assertTrue(label);
    }
}

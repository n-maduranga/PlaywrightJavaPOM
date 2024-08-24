package com.qa.orangehrm.tests;

import com.qa.orangehrm.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void verifyAddingEmployee(){
        homePage = loginPage.appLogin("Admin","admin123");
        boolean label = homePage.verifyDashboardLabel();
        Assert.assertTrue(label);
        //Click PIM link will return PIM Page
        pimPage = homePage.clickPIM();
        //Click add employee link will return Add Employee Page
        addEmpPage = pimPage.clickaddEmployee();
        boolean heading = addEmpPage.verifyAddEmpHeading();
        Assert.assertTrue(heading);
    }
}

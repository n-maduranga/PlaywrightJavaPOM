package com.qa.orangehrm.pages;

import com.microsoft.playwright.Page;

public class OrangeHRMHomePage {

    private Page page;

    //String Locators
    private String lblDashboard = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]";
    private String linkPIM = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a";
    private String linkAdmin= "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a";

    //Constructor
    public OrangeHRMHomePage(Page page) {
        this.page = page;
    }

    //Page Actions
    public OrangeHRMPIMPage clickPIM(){
        page.click(linkPIM);
        return new OrangeHRMPIMPage(page);
    }
    public boolean verifyDashboardLabel(){
        return page.isVisible(lblDashboard);
    }
    public void clickAdmin(){
        page.click(linkAdmin);
    }


}

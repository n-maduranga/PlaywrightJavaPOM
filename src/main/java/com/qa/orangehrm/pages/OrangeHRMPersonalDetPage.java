package com.qa.orangehrm.pages;

import com.microsoft.playwright.Page;

public class OrangeHRMPersonalDetPage {

    private Page page;

    String pageHeading = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6";
    public OrangeHRMPersonalDetPage(Page page) {
        this.page = page;
    }

    public boolean verifyPageHeading(){
       return page.isVisible(pageHeading);
    }
}

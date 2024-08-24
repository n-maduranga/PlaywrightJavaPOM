package com.qa.orangehrm.pages;

import com.microsoft.playwright.Page;

public class OrangeHRMPIMPage {
    private Page page;
    String buttonAdd = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button";

    public OrangeHRMPIMPage(Page page) {
        this.page = page;
    }

    public OrangeHRMAddEmpPage clickaddEmployee(){
        page.click(buttonAdd);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new OrangeHRMAddEmpPage(page);
    }
}

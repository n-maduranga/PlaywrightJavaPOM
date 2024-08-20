package com.qa.orangehrm.factory;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browsercontext;
    Properties prop;

    @BeforeTest
    public Page initializeBrowser(Properties prop){

         if (prop == null) {
            throw new RuntimeException("Properties file not loaded correctly.");
        }
        String browserName = prop.getProperty("browser");
        System.out.println("Browser Name is :"+browserName);

        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                System.out.println("Please select the correct browser");

        }
        browsercontext = browser.newContext();
        Page page = browsercontext.newPage();
        page.navigate(prop.getProperty("url"));
        return page;

    }

    //Initialize the property file
    public Properties initializeProperty(){
        try{
            FileInputStream file = new FileInputStream("src/main/java/com/qa/orangehrm/config/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

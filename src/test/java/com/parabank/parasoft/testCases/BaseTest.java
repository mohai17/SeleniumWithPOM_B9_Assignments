package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

    WebDriver webDriver;
    BasePage basePage;


    @BeforeMethod
    public void setupBrowser(){

        webDriver = new FirefoxDriver();
        webDriver.get("https://parabank.parasoft.com/");
        webDriver.manage().window().maximize();

        basePage = new BasePage(webDriver);

    }


    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }



}

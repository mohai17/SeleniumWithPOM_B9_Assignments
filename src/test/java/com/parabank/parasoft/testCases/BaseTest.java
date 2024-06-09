package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest{

    WebDriver webDriver;
    BasePage basePage;


    @BeforeClass
    public void setupBrowser(){

        webDriver = new FirefoxDriver();
        webDriver.get("https://parabank.parasoft.com/");
        webDriver.manage().window().maximize();

        basePage = new BasePage(webDriver);

    }


    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
    }



}

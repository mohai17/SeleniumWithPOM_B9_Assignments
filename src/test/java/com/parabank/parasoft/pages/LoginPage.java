package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String pageTitle(){
            return getPageTitle();
    }

    public LoginPage userName(String username){

        By locator = By.cssSelector("input[name='username']");
        waitForElement(locator);
        getPageElement(locator).sendKeys(username);
        return this;
    }

    public LoginPage password(String password){

        By locator = By.cssSelector("input[name='password']");
        waitForElement(locator);
        getPageElement(locator).sendKeys(password);
        return this;
    }

    public AccountOverviewPage loginButtonClick(){

        getPageElement(By.cssSelector("input[type='submit']")).click();
        return getInstance(AccountOverviewPage.class);

    }



}

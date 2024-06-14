package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindTransactions extends BasePage{


    public FindTransactions(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage userName(String username){

        By locator = By.cssSelector("input[name='username']");
        waitForElement(locator);
        getPageElement(locator).sendKeys(username);
        return getInstance(LoginPage.class);
    }

    public LoginPage password(String password){

        By locator = By.cssSelector("input[name='password']");
        waitForElement(locator);
        getPageElement(locator).sendKeys(password);
        return getInstance(LoginPage.class);
    }

    public AccountOverviewPage loginButtonClick(){

        getPageElement(By.cssSelector("input[type='submit']")).click();
        return getInstance(AccountOverviewPage.class);

    }


}

package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage{

    public AccountOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean hasLogoutLink(){

        return !getPageElements(By.linkText("Log Out")).isEmpty();

    }

    public LoginPage logout(){

        getPageElement(By.linkText("Log Out")).click();

        return getInstance(LoginPage.class);

    }

}

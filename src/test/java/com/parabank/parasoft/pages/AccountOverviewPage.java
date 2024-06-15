package com.parabank.parasoft.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountOverviewPage extends BasePage{

    public AccountOverviewPage(WebDriver webDriver) {
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
        return this;

    }


    public AccountOverviewPage overviewPageLinkClick(){

        getPageElement(By.cssSelector("a[href='overview.htm']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ActivityPage accountNoClick(){
        getPageElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).click();
        return getInstance(ActivityPage.class);

    }



    public boolean hasLogoutLink(){

        return !getPageElements(By.linkText("Log Out")).isEmpty();

    }

    public LoginPage logout(){

        getPageElement(By.linkText("Log Out")).click();

        return getInstance(LoginPage.class);

    }

}

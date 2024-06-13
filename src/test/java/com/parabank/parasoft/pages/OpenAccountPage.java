package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BasePage{

    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage userName(String username){

        getPageElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return getInstance(LoginPage.class);
    }

    public LoginPage password(String password){

        getPageElement(By.cssSelector("input[name='password']")).sendKeys(password);
        return getInstance(LoginPage.class);
    }

    public AccountOverviewPage loginButtonClick(){

        getPageElement(By.cssSelector("input[type='submit']")).click();
        return getInstance(AccountOverviewPage.class);

    }

    public OpenAccountPage openAccountLink(){

        getPageElement(By.cssSelector("a[href='openaccount.htm']")).click();
        return this;
    }

    public OpenAccountPage typeOfAccount(String accountType){

        WebElement element = getPageElement(By.cssSelector("select[id='type']"));
        Select select = new Select(element);
        select.selectByVisibleText(accountType);

        return this;
    }

    public OpenAccountPage existingAccountId(String accountID){
        WebElement element = getPageElement(By.cssSelector("select[id='fromAccountId']"));
        Select select = new Select(element);
        select.selectByVisibleText(accountID);

        return this;
    }

    public OpenAccountPage openAccountButtonClick(){
        getPageElement(By.cssSelector("input[value='Open New Account']")).click();
        return this;
    }

    public boolean isOpenAccountSucceed(){

        return !getPageElements(By.cssSelector("a[id='newAccountId']")).isEmpty();
    }



    public OpenAccountPage logout(){
        getPageElement(By.cssSelector("a[href='logout.htm']")).click();
        return this;
    }


}

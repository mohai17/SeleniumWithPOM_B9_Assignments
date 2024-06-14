package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class TransferFundsPage extends BasePage{


    public TransferFundsPage(WebDriver webDriver) {
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


    public TransferFundsPage transferFundsLinkClick(){

        getPageElement(By.cssSelector("a[href='transfer.htm']")).click();
        return getInstance(TransferFundsPage.class);
    }

    public TransferFundsPage amount(String amount){

        getPageElement(By.cssSelector("input[id='amount']")).sendKeys(amount);
        return getInstance(TransferFundsPage.class);

    }

    public TransferFundsPage senderAccount(){

        waitImplicitlyForElement();
        WebElement webElement = getPageElement(By.cssSelector("select[id='fromAccountId']"));
        Select select = new Select(webElement);
        select.selectByValue("13677");
        return getInstance(TransferFundsPage.class);
    }

    public TransferFundsPage receiverAccount(){

        WebElement webElement = getPageElement(By.cssSelector("select[id='toAccountId']"));
        webElement.click();
        Select select = new Select(webElement);
        select.selectByValue("13677");
        return getInstance(TransferFundsPage.class);
    }

    public TransferFundsPage transferButtonClick(){

        getPageElement(By.cssSelector("input[value='Transfer']")).click();

        return getInstance(TransferFundsPage.class);

    }

    public boolean isTransferSucceed(){
        return !getPageElements(By.xpath("//h1[normalize-space()='Transfer Complete!']")).isEmpty();
    }

    public LoginPage logout(){
        getPageElement(By.cssSelector("a[href='logout.htm']")).click();
        return getInstance(LoginPage.class);
    }

}

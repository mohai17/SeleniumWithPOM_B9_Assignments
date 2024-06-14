package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BillPay extends BasePage{

    public BillPay(WebDriver webDriver) {
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

    public BillPay billPayLinkClick(){

        getPageElement(By.cssSelector("a[href='billpay.htm']")).click();
        return getInstance(BillPay.class);
    }


    public BillPay  payeeName(String payeeName){
        getPageElement(By.cssSelector("input[name='payee.name']")).sendKeys(payeeName);
        return getInstance(BillPay.class);
    }

    public BillPay street(String street){
        getPageElement(By.cssSelector("input[name='payee.address.street']")).sendKeys(street);
        return getInstance(BillPay.class);
    }

    public BillPay city(String city){
        getPageElement(By.cssSelector("input[name='payee.address.city']")).sendKeys(city);
        return getInstance(BillPay.class);
    }

    public BillPay state(String state){
        getPageElement(By.cssSelector("input[name='payee.address.state']")).sendKeys(state);
        return getInstance(BillPay.class);
    }

    public BillPay zipCode(String zipCode){
        getPageElement(By.cssSelector("input[name='payee.address.zipCode']")).sendKeys(zipCode);
        return getInstance(BillPay.class);

    }
    public BillPay phoneNumber(String phoneNumber){
        getPageElement(By.cssSelector("input[name='payee.phoneNumber']")).sendKeys(phoneNumber);
        return getInstance(BillPay.class);
    }

    public BillPay accountNumber(String accountNumber){
        getPageElement(By.cssSelector("input[name='payee.accountNumber']")).sendKeys(accountNumber);
        return getInstance(BillPay.class);
    }

    public BillPay verifyAccount(String accountNumber){
        getPageElement(By.cssSelector("input[name='verifyAccount']")).sendKeys(accountNumber);
        return getInstance(BillPay.class);
    }


    public BillPay amount(String amount){
        getPageElement(By.cssSelector("input[name='amount']")).sendKeys(amount);
        return getInstance(BillPay.class);
    }
    public BillPay accountID(String accountID){

        Select select = new Select(getPageElement(By.cssSelector("select[name='fromAccountId']")));
        select.selectByVisibleText(accountID);
        return getInstance(BillPay.class);
    }

    public BillPay paymentButtonClick(){

        getPageElement(By.cssSelector("input[value='Send Payment']")).click();
        return getInstance(BillPay.class);
    }

    public boolean isPaymentSucceed(){
        return !getPageElements(By.cssSelector("div[id='billpayResult']")).isEmpty();
    }

    public boolean isErrorFound(){
        return getPageElements(By.className("error")).size()<=15;
    }


    public void logOut(){
        getPageElement(By.cssSelector("a[href='logout.htm']")).click();
    }
}

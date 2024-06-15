package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RequestLoan extends BasePage{

    public RequestLoan(WebDriver webDriver) {
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
    public RequestLoan requestLoanLinkClick(){

        getPageElement(By.cssSelector("a[href='requestloan.htm']")).click();
        return getInstance(RequestLoan.class);
    }

    public RequestLoan loanAmountField(String loanAmount){

        getPageElement(By.cssSelector("input[id='amount']")).sendKeys(loanAmount);
        return getInstance(RequestLoan.class);
    }

    public RequestLoan downPaymentField(String downPayment){

        getPageElement(By.cssSelector("input[id='downPayment']")).sendKeys(downPayment);
        return getInstance(RequestLoan.class);
    }

    public RequestLoan fromAccountField(String accountId){

        WebElement element = getPageElement(By.cssSelector("select[id='fromAccountId']"));
        Select select = new Select(element);
        select.selectByVisibleText(accountId);

        return this;
    }

    public RequestLoan applyNowButtonClick(){
        getPageElement(By.cssSelector("input[value='Apply Now']")).click();
        return this;
    }

    public boolean isLoanApproved(){

       return !getPageElements(By.cssSelector("div[id='requestLoanResult']")).isEmpty();

    }

    public boolean isErrorFound(){
        return getPageElements(By.className("error")).size() <=3;
    }

}

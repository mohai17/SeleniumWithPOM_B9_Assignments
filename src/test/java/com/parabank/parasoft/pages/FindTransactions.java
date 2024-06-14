package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindTransactions extends BasePage{


    public FindTransactions(WebDriver webDriver) {
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

    public FindTransactions findTransactionsLinkClick(){

        getPageElement(By.cssSelector("a[href='findtrans.htm']")).click();
        return this;
    }

    public FindTransactions idSelection(String accountNo){
        WebElement element = getPageElement(By.cssSelector("select[id='accountId']"));
        Select select = new Select(element);
        select.selectByValue(accountNo);
        return this;
    }

    public FindTransactions findByTransactionID(String TransactionId){

        getPageElement(By.cssSelector("input[id='transactionId']")).sendKeys(TransactionId);

        return this;
    }

    public FindTransactions findByDate(String TransactionDate){

        getPageElement(By.cssSelector("input[id='transactionDate']")).sendKeys(TransactionDate);

        return this;
    }

    public FindTransactions findByDateRange(String fromDate, String toDate){

        getPageElement(By.cssSelector("input[id='fromDate']")).sendKeys(fromDate);
        getPageElement(By.cssSelector("input[id='toDate']")).sendKeys(toDate);

        return this;
    }
    public FindTransactions findByAmount(String amount){

        getPageElement(By.cssSelector("input[id='amount']")).sendKeys(amount);
        return this;
    }

    public FindTransactions findByIdButton(){

        getPageElement(By.cssSelector("button[id='findById']")).click();
        return this;

    }

    public FindTransactions findByDateButton(){

        getPageElement(By.cssSelector("button[id='findByDate']")).click();
        return this;

    }

    public FindTransactions findByDateRangeButton(){

        getPageElement(By.cssSelector("button[id='findByDateRange']")).click();
        return this;

    }

    public FindTransactions findByAmountButton(){

        getPageElement(By.cssSelector("button[id='findByAmount']")).click();
        return this;

    }

    public boolean isErrorExisted(){

        return getPageElements(By.className("error")).size() <= 7;
    }

    public boolean isDataFound(){
        return !getPageElements(By.cssSelector("div[id='resultContainer']")).isEmpty();
    }


}

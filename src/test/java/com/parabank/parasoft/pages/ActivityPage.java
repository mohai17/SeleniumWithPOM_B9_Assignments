package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActivityPage extends BasePage{

    public ActivityPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ActivityPage periodSelection(){

        WebElement element = getPageElement(By.cssSelector("select[id='month']"));
        Select select = new Select(element);
        select.selectByIndex(6);
        return this;
    }

    public ActivityPage typeSelection(){

        WebElement element = getPageElement(By.cssSelector("select[id='transactionType']"));
        Select select = new Select(element);
        select.selectByIndex(2);
        return this;
    }

    public ActivityPage goButtonClick(){
        getPageElement(By.cssSelector("input[value='Go']")).click();
        return this;
    }

    public boolean isPass(){
        boolean x = !getPageElements(By.cssSelector("table[id='transactionTable']")).isEmpty();
        boolean y = !getPageElements(By.cssSelector("table[id='noTransactions']")).isEmpty();

        return x||y;
    }
}

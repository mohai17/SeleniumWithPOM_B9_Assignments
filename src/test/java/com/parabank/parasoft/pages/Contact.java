package com.parabank.parasoft.pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contact extends BasePage{

    public Contact(WebDriver webDriver) {
        super(webDriver);
    }

    public Contact clickContact(){
        getPageElement(By.className("contact")).click();
        return this;
    }

    public Contact name(String name){
        getPageElement(By.cssSelector("input[id='name']")).sendKeys(name);
        return this;
    }

    public Contact email(String email){
        getPageElement(By.cssSelector("input[id='email']")).sendKeys(email);
        return this;
    }
//
//
    public Contact phone(String phone){
        getPageElement(By.cssSelector("input[id='phone']")).sendKeys(phone);
        return this;
    }
    public Contact textArea(String comment){
        getPageElement(By.cssSelector("textarea[id='message']")).sendKeys(comment);
        return this;
    }
    public Contact submitButtonClick(){
        getPageElement(By.cssSelector("input[value='Send to Customer Care']")).click();
        return this;
    }
    public boolean isPass(){

        return !getPageElements(By.xpath("//div[@id='rightPanel']")).isEmpty();
    }
}

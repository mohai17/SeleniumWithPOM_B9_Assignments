package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLookUpPage extends BasePage{

    public CustomerLookUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CustomerLookUpPage firstName(String firstName){
        getPageElement(By.cssSelector("input[id='firstName']")).sendKeys(firstName);
        return this;
    }

    public CustomerLookUpPage lastName(String lastName){
        getPageElement(By.cssSelector("input[id='lastName']")).sendKeys(lastName);
        return this;
    }
    public CustomerLookUpPage  address(String address){
        getPageElement(By.cssSelector("input[id='address.street']")).sendKeys(address);
        return this;
    }
    public CustomerLookUpPage  city(String city){
        getPageElement(By.cssSelector("input[id='address.city']")).sendKeys(city);
        return this;
    }
    public CustomerLookUpPage  state(String state){
        getPageElement(By.cssSelector("input[id='address.state']")).sendKeys(state);
        return this;
    }
    public CustomerLookUpPage  zipCode(String zipCode){
        getPageElement(By.cssSelector("input[id='address.zipCode']")).sendKeys(zipCode);
        return this;
    }
    public CustomerLookUpPage  socialSecurityNumber(String ssn){
        getPageElement(By.cssSelector("input[id='ssn']")).sendKeys(ssn);
        return this;
    }
    public CustomerLookUpPage  findMyLoginInfo(){
        getPageElement(By.cssSelector("input[value='Find My Login Info']")).click();
        return this;
    }
    public boolean isLocatedSuccessfully(){
        return !getPageElements(By.cssSelector("#rightPanel > p:nth-child(2)")).isEmpty();
    }
    public boolean isErrorFound(){
        return getPageElements(By.className("error")).size() <= 7;
    }

    public boolean isUserNotFound(){
        return !getPageElements(By.className("error")).isEmpty();
    }

    public LoginPage logOutLookUp(){
        getPageElement(By.cssSelector("#leftPanel > ul:nth-child(3) > li:nth-child(8) > a:nth-child(1)")).click();
        return  getInstance(LoginPage.class);
    }
}

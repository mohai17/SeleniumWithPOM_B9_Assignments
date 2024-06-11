package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public RegisterPage registerLinkClick(){
        getPageElement(By.cssSelector("a[href='register.htm']")).click();
        return this;
    }

    public RegisterPage firstName(String firstname){
        getPageElement(By.cssSelector("input[id='customer.firstName']")).sendKeys(firstname);
        return this;
    }

    public RegisterPage lastName(String lastname){
        getPageElement(By.cssSelector("input[id='customer.lastName']")).sendKeys(lastname);
        return this;
    }

    public RegisterPage address(String address){
        getPageElement(By.cssSelector("input[id='customer.address.street']")).sendKeys(address);
        return this;
    }
    public RegisterPage city(String city){
        getPageElement(By.cssSelector("input[id='customer.address.city']")).sendKeys(city);
        return this;
    }
    public RegisterPage state(String state){
        getPageElement(By.cssSelector("input[id='customer.address.state']")).sendKeys(state);
        return this;
    }
    public RegisterPage zipCode(String zipcode){
        getPageElement(By.cssSelector("input[id='customer.address.zipCode']")).sendKeys(zipcode);
        return this;
    }
    public RegisterPage phoneNumber(String phoneNumber) {
        getPageElement(By.cssSelector("input[id='customer.phoneNumber']")).sendKeys(phoneNumber);
        return this;
    }

    public RegisterPage socialSecurityNumber(String ssn){
        getPageElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(ssn);
        return this;
    }


    public RegisterPage userName(String userName){
        getPageElement(By.cssSelector("input[id='customer.username']")).sendKeys(userName);
        return this;
    }
    public RegisterPage password(String password){
        getPageElement(By.cssSelector("input[id='customer.password']")).sendKeys(password);
        return this;
    }
    public RegisterPage confirmPassword(String confirmPassword){
        getPageElement(By.cssSelector("input[id='repeatedPassword']")).sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage registerButtonClick(){
        getPageElement(By.cssSelector("input[value='Register']")).click();
        return this;
    }

    public boolean isSucceed(){

        return !getPageElements(By.linkText("Log Out")).isEmpty();
//        return !getPageElements(By.partialLinkText("successfully")).isEmpty();

    }


    public boolean hasError(){
        return getPageElements(By.className("error")).size()<=10;
    }

}

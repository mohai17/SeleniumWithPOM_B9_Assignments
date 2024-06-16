package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DDTRegistrationPage extends BasePage{

    public DDTRegistrationPage(WebDriver webDriver){
        super(webDriver);
    }

    public DDTRegistrationPage registrationLinkClick(){
        General.waitToSee();
        getPageElement(By.cssSelector("a[href='register.htm']")).click();
        return this;
    }
    public DDTRegistrationPage firstName(String firstName){
        getPageElement(By.cssSelector("input[id='customer.firstName']")).sendKeys(firstName);
        return this;
    }
    public DDTRegistrationPage lastName(String lastName){
        getPageElement(By.cssSelector("input[id='customer.lastName']")).sendKeys(lastName);
        return this;
    }

    public DDTRegistrationPage address(String address){
        getPageElement(By.cssSelector("input[id='customer.address.street']")).sendKeys(address);
        return this;
    }
    public DDTRegistrationPage city(String city){
        getPageElement(By.cssSelector("input[id='customer.address.city']")).sendKeys(city);
        return this;
    }
    public DDTRegistrationPage state(String state){
        getPageElement(By.cssSelector("input[id='customer.address.state']")).sendKeys(state);
        return this;
    }
    public DDTRegistrationPage zipCode(String zipCode){
        getPageElement(By.cssSelector("input[id='customer.address.zipCode']")).sendKeys(zipCode);
        return this;
    }
    public DDTRegistrationPage phone(String phone){
        getPageElement(By.cssSelector("input[id='customer.phoneNumber']")).sendKeys(phone);
        return this;
    }
    public DDTRegistrationPage ssn(String ssn){
        getPageElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(ssn);
        return this;
    }
    public DDTRegistrationPage userName(String userName){
        getPageElement(By.cssSelector("input[id='customer.username']")).sendKeys(userName);
        return this;
    }
    public DDTRegistrationPage password(String password){
        getPageElement(By.cssSelector("input[id='customer.password']")).sendKeys(password);
        return this;
    }
    public DDTRegistrationPage confirmPassword(String cpassword){
        getPageElement(By.cssSelector("input[id='repeatedPassword']")).sendKeys(cpassword);
        return this;
    }
    public DDTRegistrationPage registrationButtonClick(){
        getPageElement(By.cssSelector("input[value='Register']")).click();
        return this;
    }
    public void logout(){
        getPageElement(By.linkText("Log Out")).click();
    }

    public boolean isSucceed(){
        return !getPageElements(By.linkText("Log Out")).isEmpty();
    }
}

package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContactInfo extends BasePage{

    public UpdateContactInfo(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage userName(String userName){

        getPageElement(By.cssSelector("input[name='username']")).sendKeys(userName);
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

    public UpdateContactInfo updateContactInfoLinkClick(){

        getPageElement(By.cssSelector("a[href='updateprofile.htm']")).click();

        return this;

    }

    public UpdateContactInfo firstNameField(String firstName){

       WebElement element = getPageElement(By.cssSelector("input[id='customer.firstName']"));
       element.clear();
       element.sendKeys(firstName);

       return this;
    }

    public UpdateContactInfo lastNameField(String lastName){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.lastName']"));
        element.clear();
        element.sendKeys(lastName);

        return this;
    }

    public UpdateContactInfo streetField(String street){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.address.street']"));
        element.clear();
        element.sendKeys(street);

        return this;
    }

    public UpdateContactInfo cityField(String city){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.address.city']"));
        element.clear();
        element.sendKeys(city);

        return this;
    }

    public UpdateContactInfo stateField(String state){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.address.state']"));
        element.clear();
        element.sendKeys(state);

        return this;
    }

    public UpdateContactInfo zipCodeField(String zipCode){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.address.zipCode']"));
        element.clear();
        element.sendKeys(zipCode);

        return this;
    }

    public UpdateContactInfo phoneNumber(String phoneNumber){

        WebElement element = getPageElement(By.cssSelector("input[id='customer.phoneNumber']"));
        element.clear();
        element.sendKeys(phoneNumber);

        return this;
    }

    public UpdateContactInfo updateButtonClick(){

        getPageElement(By.cssSelector("input[value='Update Profile']")).click();

        return this;
    }

    public boolean isProfileUpdated(){

        return !getPageElements(By.cssSelector("div[id='updateProfileResult']")).isEmpty();

    }

    public boolean isErrorFound(){

        return getPageElements(By.className("error")).size() <=8;
    }

}

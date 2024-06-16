package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DDTLoginPage extends BasePage{

    public DDTLoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public DDTLoginPage userNameField(String userName){
        getPageElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        return this;
    }

    public DDTLoginPage passwordField(String password){
        getPageElement(By.cssSelector("input[name='password']")).sendKeys(password);
        return this;
    }

    public void loginButtonClick(){
        getPageElement(By.cssSelector("input[value='Log In']")).click();
    }

    public DDTLoginPage logout(){
        getPageElement(By.linkText("Log Out")).click();
        return this;
    }

    public boolean isSucceed(){
        return !getPageElements(By.cssSelector("a[href='logout.htm']")).isEmpty();
    }

}

package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

import static com.parabank.parasoft.util.General.WAIT_TIME;

public class BasePage extends Page{

    WebDriver webDriver;
    WebDriverWait wait;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIME));
    }

    @Override
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    @Override
    public WebElement getPageElement(By locator) {
        WebElement element = null;
        try{
            element = webDriver.findElement(locator);
        }catch (Exception e){
            System.out.println(locator.toString()+"Locator is not found.");
        }
        return element;
    }

    @Override
    public List<WebElement> getPageElements(By locator) {

        List<WebElement> elements = null;
        try{
            elements = webDriver.findElements(locator);
        }catch (Exception e){
            System.out.println(locator.toString()+"Locator is not found.");
        }
        return elements;
    }

    @Override
    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public void waitImplicitlyForElement() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Override
    public <T extends BasePage> T getInstance(Class<T> tClass) {

        try {
           return tClass.getDeclaredConstructor(WebDriver.class).newInstance(webDriver);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}

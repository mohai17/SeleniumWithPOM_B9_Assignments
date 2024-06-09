package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Page {

    public abstract String getPageTitle();
    public abstract WebElement getPageElement(By locator);
    public abstract List<WebElement> getPageElements(By locator);
    public abstract void waitForElement(By locator);
    public abstract <T extends BasePage> T getInstance(Class<T> tClass);
    
}

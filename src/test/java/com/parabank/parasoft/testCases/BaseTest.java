package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest{

    WebDriver webDriver;
    BasePage basePage;
    private final Properties properties;

    public BaseTest(){

        try {
            properties = new Properties();
            String filepath = System.getProperty("user.dir")+"/src/test/resources/updateContactInfoConfig.properties";
            FileInputStream inputStream = new FileInputStream(filepath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @BeforeMethod
    public void setupBrowser(){

        String browserName = properties.getProperty("browserName");

        switch (browserName){

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "firefox_headless":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                webDriver = new FirefoxDriver(options);
                break;

            case "chrome":
                webDriver = new ChromeDriver();
                break;
            default:
                System.out.println("Provide a browser.");
        }

        webDriver.get(properties.getProperty("url"));
        webDriver.manage().window().maximize();

        basePage = new BasePage(webDriver);

    }


    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

    public String getUserName(){
        return properties.getProperty("userName");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public String getFirstName(){
        return properties.getProperty("firstName");
    }

    public String getLastName(){
        return properties.getProperty("lastName");
    }

    public String getStreet(){
        return properties.getProperty("street");
    }

    public String getCity(){
        return properties.getProperty("city");
    }

    public String getState(){
        return properties.getProperty("state");
    }

    public String getZipCode(){
        return properties.getProperty("zipCode");
    }

    public String getPhoneNumber(){
        return properties.getProperty("phoneNumber");
    }


}

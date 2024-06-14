package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

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
            String filepath = System.getProperty("user.dir")+"/src/test/resources/registerConfig.properties";
            FileInputStream fileInputStream = new FileInputStream(filepath);
            properties.load(fileInputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void setupBrowser(){

        String browserName = properties.getProperty("browserName");
        String url = properties.getProperty("url");

        switch (browserName){
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "firefoxHeadless":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            default:
                System.out.println("Provide a browser.");

        }

        webDriver.get(url);
        webDriver.manage().window().maximize();
        basePage = new BasePage(webDriver);

    }


    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
    }

    public String getUserName(){
        return properties.getProperty("username");
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

    public String getAddress(){
        return properties.getProperty("address");
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

    public String getSSN(){
        return properties.getProperty("SSN");
    }
    public String getConfirmPassword(){
        return properties.getProperty("confirmPassword");
    }


}

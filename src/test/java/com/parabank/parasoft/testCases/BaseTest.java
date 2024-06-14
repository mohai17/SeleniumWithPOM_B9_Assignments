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
            String filepath = System.getProperty("user.dir")+"/src/test/resources/findTransactionsConfig.properties";
            FileInputStream inputStream = new FileInputStream(filepath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeClass
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
                System.out.println("Browser not found.");
                break;

        }


        webDriver.get(properties.getProperty("url"));
        webDriver.manage().window().maximize();

        basePage = new BasePage(webDriver);

    }


    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
    }



}

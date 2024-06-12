package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.CustomerLookUpPage;
import com.parabank.parasoft.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLookUpTest extends BaseTest{

    @Test
    public void lookUpSucceed(){
        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.forgotLinkClick();

        CustomerLookUpPage lookUpPage = basePage.getInstance(CustomerLookUpPage.class);

        boolean actual = lookUpPage.firstName(getFirstName())
                .lastName(getLastName())
                .address(getAddress())
                .city(getCity())
                .state(getState())
                .zipCode(getZipCode())
                .socialSecurityNumber(getSSN())
                .findMyLoginInfo()
                .isLocatedSuccessfully();

        Assert.assertTrue(actual);

        lookUpPage.logOutLookUp();

    }

@Test
    public void lookupFailedForBlankField(){

    LoginPage loginPage = basePage.getInstance(LoginPage.class);
    loginPage.forgotLinkClick();
    CustomerLookUpPage lookUpPage = basePage.getInstance(CustomerLookUpPage.class);

        boolean actual = lookUpPage.firstName(getFirstName())
            .lastName(getLastName())
            .address(getAddress())
            .state(getState())
            .zipCode(getZipCode())
            .findMyLoginInfo()
                .isErrorFound();

        Assert.assertTrue(actual);

    }

    @Test
    public void lookupFailedForAllBlankField(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.forgotLinkClick();
        CustomerLookUpPage lookUpPage = basePage.getInstance(CustomerLookUpPage.class);

        boolean actual = lookUpPage.isErrorFound();

        Assert.assertTrue(actual);

    }


    @Test
    public void lookUpFailedWithUserNotFound(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.forgotLinkClick();
        CustomerLookUpPage lookUpPage = basePage.getInstance(CustomerLookUpPage.class);
        boolean actual = lookUpPage.firstName("a")
                .lastName("a")
                .address("a")
                .city("a")
                .state("a")
                .zipCode("a")
                .socialSecurityNumber("a")
                .findMyLoginInfo()
                .isUserNotFound();

        Assert.assertTrue(actual);

    }


}

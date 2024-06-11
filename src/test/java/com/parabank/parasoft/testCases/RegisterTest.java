package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test(priority = 0)
    public void registerFailedWithAnyBlankField(){

        LoremIpsum lorem = new LoremIpsum();
        String fName = lorem.getFirstName();

        RegisterPage registerPage = basePage.getInstance(RegisterPage.class);
        boolean actual = registerPage.registerLinkClick()
                .firstName(fName)
                .lastName(lorem.getLastName())
                .city(lorem.getCity())
                .state(lorem.getStateFull())
                .zipCode(lorem.getZipCode())
                .phoneNumber(lorem.getPhone())
                .userName(fName)
                .password(fName)
                .confirmPassword(fName)
                .registerButtonClick()
                .hasError();

        Assert.assertTrue(actual);

    }

    @Test(priority = 1)
    public void registerFailedWithAllBlankField(){
        RegisterPage registerPage = basePage.getInstance(RegisterPage.class);
        boolean actual = registerPage.registerLinkClick().registerButtonClick().hasError();
        Assert.assertTrue(actual);
    }

    @Test(priority = 2)
    public void registerSucceed(){

        LoremIpsum lorem = new LoremIpsum();
        String fName = lorem.getFirstName();

        RegisterPage registerPage = basePage.getInstance(RegisterPage.class);
        boolean actual = registerPage.registerLinkClick()
                .firstName(fName)
                .lastName(lorem.getLastName())
                .address(lorem.getWords(3))
                .city(lorem.getCity())
                .state(lorem.getStateFull())
                .zipCode(lorem.getZipCode())
                .phoneNumber(lorem.getPhone())
                .socialSecurityNumber("123-4560-789")
                .userName(fName)
                .password(fName)
                .confirmPassword(fName)
                .registerButtonClick()
                .isSucceed();

        Assert.assertTrue(actual);

    }
}

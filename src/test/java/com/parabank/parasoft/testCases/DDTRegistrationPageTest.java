package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.DDTRegistrationPage;
import com.parabank.parasoft.util.General;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTRegistrationPageTest extends BaseTest{

    @DataProvider
    public Object[][] getDataProvider(){
        return General.getData("MySheet01");
    }

    @Test(dataProvider = "getDataProvider")
    public void registrationSucceed(String... args){

        DDTRegistrationPage ddtRegistrationPage = basePage.getInstance(DDTRegistrationPage.class);

       boolean actual = ddtRegistrationPage.registrationLinkClick()
                .firstName(args[0])
                .lastName(args[1])
                .address(args[2])
                .city(args[3])
                .state(args[4])
                .zipCode(args[5])
                .phone(args[6])
                .ssn(args[7])
                .userName(args[8])
                .password(args[9])
                .confirmPassword(args[9])
                .registrationButtonClick()
                .isSucceed();

        Assert.assertTrue(actual);
        ddtRegistrationPage.logout();

    }

}

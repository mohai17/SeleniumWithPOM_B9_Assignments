package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OpenAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest{

    @Test

    public void openCheckingAccountSucceed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.userName(getUserName())
                 .password(getPassword())
                 .loginButtonClick();

        OpenAccountPage openAccountPage = basePage.getInstance(OpenAccountPage.class);

        boolean actual = openAccountPage.openAccountLink()
                .typeOfAccount("CHECKING")
                .openAccountButtonClick()
                .isOpenAccountSucceed();

        Assert.assertTrue(actual);

        openAccountPage.logout();

    }

    @Test
    public void openSavingsAccountSucceed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.userName(getUserName())
                .password(getPassword())
                .loginButtonClick();

        OpenAccountPage openAccountPage = basePage.getInstance(OpenAccountPage.class);

        boolean actual = openAccountPage.openAccountLink()
                .typeOfAccount("SAVINGS")
                .openAccountButtonClick()
                .isOpenAccountSucceed();

        Assert.assertTrue(actual);

        openAccountPage.logout();
    }




}

package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void titleTest(){

        String title = basePage.getPageTitle();
        String expected = "ParaBank | Welcome | Online Banking";

        Assert.assertEquals(title,expected);
    }

    @Test
    public void loginSucceed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        AccountOverviewPage accountOverviewPage = loginPage
                 .userName("nayeem")
                         .password("nayeem")
                                 .loginButtonClick();

        Assert.assertTrue(accountOverviewPage.hasLogoutLink());

        accountOverviewPage.logout();

    }

    @Test
    public void loginFailed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        boolean loginError = loginPage
                .userName("")
                        .password("")
                                .loginButtonClickF()
                                        .hasLoginError();

        Assert.assertTrue(loginError);

    }

}

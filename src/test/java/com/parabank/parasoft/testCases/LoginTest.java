package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.util.General;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void titleTest(){

        String actual = basePage.getPageTitle();
        String expected = General.HOME_PAGE_TITLE;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void loginSucceed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        AccountOverviewPage accountOverviewPage = loginPage
                 .userName(getUserName())
                         .password(getPassword())
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

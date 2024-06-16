package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.DDTLoginPage;
import com.parabank.parasoft.util.General;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTLoginPageTest extends BaseTest{

    @DataProvider
    public Object[][] getSheetData(){
        return General.getData("MySheet01");
    }

    @Test(dataProvider = "getSheetData")
    public void loginTest(String... args){

        DDTLoginPage ddtLoginPage = basePage.getInstance(DDTLoginPage.class);

        ddtLoginPage.userNameField(args[8])
                            .passwordField(args[9])
                            .loginButtonClick();

        boolean actual = ddtLoginPage.isSucceed();
        Assert.assertTrue(actual);

        ddtLoginPage.logout();
    }

}

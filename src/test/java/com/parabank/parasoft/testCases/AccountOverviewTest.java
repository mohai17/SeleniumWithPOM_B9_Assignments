package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.ActivityPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountOverviewTest extends BaseTest{

    @Test
    public void accountOverviewPass(){

        AccountOverviewPage overviewPage = basePage.getInstance(AccountOverviewPage.class);
        overviewPage.userName("sqa").password("sqa")
                .loginButtonClick()
                .overviewPageLinkClick()
                .accountNoClick();

        ActivityPage activityPage = basePage.getInstance(ActivityPage.class);

        boolean actual = activityPage.periodSelection()
                .typeSelection()
                .goButtonClick()
                .isPass();

        Assert.assertTrue(actual);


    }

}

package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest{

    @Test
    public void transferFundsSucceed(){

        LoginPage loginPage = basePage.getInstance(LoginPage.class);
        loginPage.userName(getUserName())
                .password(getPassword())
                .loginButtonClick();

        TransferFundsPage transferFundsPage = basePage.getInstance(TransferFundsPage.class);
        boolean actual = transferFundsPage.transferFundsLinkClick()
                .amount(getAmount())
                .senderAccount()
                .receiverAccount()
                .transferButtonClick()
                .isTransferSucceed();

        Assert.assertTrue(actual);

        transferFundsPage.logout();

    }


}

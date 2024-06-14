package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.BillPay;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPayTest extends BaseTest{

    @Test(priority = 2)
    public void billPaySucceed(){

        BillPay billpay = basePage.getInstance(BillPay.class);
        billpay.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = billpay.billPayLinkClick()
                .payeeName(getGeneralPurpose())
                .street(getGeneralPurpose())
                .city(getGeneralPurpose())
                .state(getGeneralPurpose())
                .zipCode(getGeneralPurpose())
                .phoneNumber(getGeneralPurpose())
                .accountNumber(getAccountID())
                .verifyAccount(getAccountID())
                .amount(getAmount())
                .accountID(getFromAccountID())
                .paymentButtonClick()
                .isPaymentSucceed();

        Assert.assertTrue(actual);
        billpay.logOut();

    }

    @Test(priority = 0)
    public void billPayFailedWithBlankField(){
        BillPay billpay = basePage.getInstance(BillPay.class);
        billpay.userName("sqa").password("sqa").loginButtonClick();
        boolean actual = billpay.billPayLinkClick()
                .payeeName("sqa")
                .street("sqa")
                .city("sqa")
                .accountNumber("13788")
                .verifyAccount("13788")
                .amount("500")
                .accountID("14121")
                .paymentButtonClick()
                .isPaymentSucceed();

        Assert.assertTrue(actual);
        billpay.logOut();
    }

    @Test(priority = 1)
    public void billPayFailedWithAllBlankField() {
        BillPay billpay = basePage.getInstance(BillPay.class);
        billpay.userName("sqa").password("sqa").loginButtonClick();
        boolean actual = billpay.billPayLinkClick().paymentButtonClick().isErrorFound();

        Assert.assertTrue(actual);
        billpay.logOut();
    }


}

package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.RequestLoan;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestLoanTest extends BaseTest{

    @Test
    public void loanApprovalSucceed(){
        RequestLoan requestLoan = basePage.getInstance(RequestLoan.class);

        requestLoan.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = requestLoan.requestLoanLinkClick()
                .loanAmountField(getLoanAmount())
                .downPaymentField(getDownPayment())
                .fromAccountField(getAccountId())
                .applyNowButtonClick()
                .isLoanApproved();

        Assert.assertTrue(actual);
    }

    @Test
    public void loanApprovalFailedWithBlankField(){

        RequestLoan requestLoan = basePage.getInstance(RequestLoan.class);

        requestLoan.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = requestLoan.requestLoanLinkClick()
                .applyNowButtonClick()
                .isErrorFound();

        Assert.assertTrue(actual);
    }

}

package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.FindTransactions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTransactionsTest extends BaseTest{

    @Test
    public void findByTransactionId(){

        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = findTransactions.findTransactionsLinkClick()
                .idSelection(getAccountNo())
                        .findByTransactionID(getTransactionId())
                                .findByIdButton()
                                        .isDataFound();

        Assert.assertTrue(actual);

        findTransactions.findTransactionsLinkClick();

    }

    @Test
    public void findByDate(){

        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = findTransactions.findTransactionsLinkClick()
                        .findByDate(getDate())
                                .findByDateButton()
                                        .isDataFound();

        Assert.assertTrue(actual);
        findTransactions.findTransactionsLinkClick();
    }

    @Test
    public void findByDateRange(){

        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = findTransactions.findTransactionsLinkClick()
                        .findByDateRange(getFromDate(),getToDate())
                                .findByDateRangeButton()
                                        .isDataFound();


        Assert.assertTrue(actual);
        findTransactions.findTransactionsLinkClick();

    }

    @Test
    public void findByAmount(){


        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = findTransactions.findTransactionsLinkClick()
                        .findByAmount(getAmount())
                                .findByAmountButton()
                                        .isDataFound();

        Assert.assertTrue(actual);
        findTransactions.findTransactionsLinkClick();
    }

    @Test
    public void findByIdFailed(){

        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();
        boolean actual = findTransactions.findTransactionsLinkClick().findByIdButton().isErrorExisted();

        Assert.assertTrue(actual);

    }
    @Test
    public void findByDateFailed(){

        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = findTransactions.findTransactionsLinkClick().findByDateButton().isErrorExisted();
        Assert.assertTrue(actual);

    }
    @Test
    public void findByDateRangeFailed(){
        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = findTransactions.findTransactionsLinkClick().findByDateRangeButton().isErrorExisted();
        Assert.assertTrue(actual);
    }

    @Test
    public void findByAmountFailed(){
        FindTransactions findTransactions = basePage.getInstance(FindTransactions.class);
        findTransactions.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = findTransactions.findTransactionsLinkClick().findByAmountButton().isErrorExisted();
        Assert.assertTrue(actual);

    }



}

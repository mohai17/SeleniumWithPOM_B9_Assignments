package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest{

    @Test
    public void customerCareSucceed(){

        Contact contact = basePage.getInstance(Contact.class);
        boolean actual = contact.clickContact()
                .name("nayeem")
                .email("nayeem@gmail.com")
                .phone("1234567890")
                .textArea("Hello How are you?")
                .submitButtonClick()
                .isPass();

        Assert.assertTrue(actual);

    }
}

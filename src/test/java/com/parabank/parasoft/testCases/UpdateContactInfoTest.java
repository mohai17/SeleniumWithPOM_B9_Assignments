package com.parabank.parasoft.testCases;

import com.parabank.parasoft.pages.UpdateContactInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateContactInfoTest extends BaseTest{

    @Test
    public void updateProfileSucceed(){

        UpdateContactInfo update = basePage.getInstance(UpdateContactInfo.class);

        update.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = update.updateContactInfoLinkClick()
                .firstNameField(getFirstName())
                .lastNameField(getLastName())
                .streetField(getStreet())
                .cityField(getCity())
                .stateField(getState())
                .zipCodeField(getZipCode())
                .phoneNumber(getPhoneNumber())
                .updateButtonClick()
                .isProfileUpdated();

        Assert.assertTrue(actual);

    }

    @Test
    public void updateProfileFailedWithAllBlankField()
    {
        UpdateContactInfo update = basePage.getInstance(UpdateContactInfo.class);

        update.userName(getUserName()).password(getPassword()).loginButtonClick();

        boolean actual = update.updateContactInfoLinkClick()
                .updateButtonClick()
                .isErrorFound();

        Assert.assertTrue(actual);
    }

}

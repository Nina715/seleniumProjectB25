package com.cydeo.test.day12_pageObject;

import com.cydeo.pages.LibraryLogInPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_errorMsg {

    //TC #1: Required field error message test
    //1- Open a chrome browser
    //2- Go to: https://library1.cydeo.com/
    @Test
    public void librarySignIn() {
        Driver.getDriver().get("https://library1.cydeo.com/");
        //3- Do not enter any information
        //4- Click to “Sign in” button
        LibraryLogInPage logInPage = new LibraryLogInPage();
        logInPage.submitButton.click();
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(logInPage.fieldRequiredErrorMsg.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}

package com.cydeo.test.day12_pageObject;

import com.cydeo.pages.LibraryLogInPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_InvalidEmailErrorMsg {
    //TC #2: Invalid email format error message test
    //1- Open a chrome browser
    //2- Go to: https://library1.cydeo.com/
    @Test
    public void Invalid_email_format_error_message_test(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        LibraryLogInPage libraryLogInPage = new LibraryLogInPage();
        Faker faker = new Faker();
        //3- Enter invalid email format
        libraryLogInPage.inputUserName.sendKeys(faker.letterify("??????"));
        libraryLogInPage.submitButton.click();
        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLogInPage.InvalidEmailAddressError.isDisplayed());
    }

}

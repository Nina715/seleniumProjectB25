package com.cydeo.test.day12_pageObject;

import com.cydeo.pages.LibraryLogInPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_NegativeLogInTest {
    //TC #3: Library negative login
    //1- Open a chrome browser
    //2- Go to: https://library1.cydeo.com/
    @Test
    public void library_negative_login(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        LibraryLogInPage libraryLogInPage = new LibraryLogInPage();
        Faker faker = new Faker();
        //3- Enter incorrect username or incorrect password
        libraryLogInPage.inputUserName.sendKeys(faker.letterify("?????@gmail.com"));
        libraryLogInPage.inputPassword.sendKeys(faker.bothify("??#???##"), Keys.ENTER);
        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLogInPage.wrongEmailOrPasswordErrMsg.isDisplayed());
    }

}

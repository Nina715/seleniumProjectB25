package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC7_NonSelectDropDown {
    WebDriver driver;
    //1. Open Chrome browser
    @BeforeMethod
    public void browserSetUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void selectFbNonDropDownTest(){
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        //3. Click to non-select dropdown
        driver.findElement(By.cssSelector("a#dropdownMenuLink")).click();
        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//a[.='Facebook']")).click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedFbTitle = "Facebook - Log In or Sign Up";
        Assert.assertTrue(driver.getTitle().equals(expectedFbTitle));
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

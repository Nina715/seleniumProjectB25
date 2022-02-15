package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TC4_SimpleDropDown {
    //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
    //default values
    //1. Open Chrome browser
    WebDriver driver;
   @BeforeMethod
    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

   }
    @Test (priority = 1)
    public void simpleDropDownTest(){
       //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        //3. Verify “Simple dropdown” default selected value is correct
        Select select = new Select(driver.findElement(By.id("dropdown")));
        //Expected: “Please select an option”
        String expectDefaultValue = "Please select an option";
        Assert.assertEquals(select.getFirstSelectedOption().getText(),expectDefaultValue,"the actual default selected option is not 'Please select an option'");
    }

    @Test (priority = 2)
    public void stateDropDownTest(){
        driver.get("https://practice.cydeo.com/dropdown");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        String expectedDefaultValue = "Select a State";
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(expectedDefaultValue));
    }

    @AfterMethod
    public void tearDown(){
       driver.close();
    }

}

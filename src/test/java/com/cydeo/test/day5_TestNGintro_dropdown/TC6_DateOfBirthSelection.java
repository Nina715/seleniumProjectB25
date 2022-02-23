package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TC6_DateOfBirthSelection {
    WebDriver driver;
    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    @BeforeClass
    public void browserSetUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test (priority = 1)
    public void yearDropDownTest(){
        //3. Select “December 1st, 1922” and verify it is selected.
        //Select year using  : visible text
        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1992");
        Assert.assertTrue(selectYear.getFirstSelectedOption().getText().equals("1992"));
    }

    @Test (priority = 2)
    public void monthDropDownTest(){
        //Select month using   : value attribute
        Select selectMonth = new Select(driver.findElement((By.id("month"))));
        selectMonth.selectByValue("11");
        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(),"December");
    }
    @Test (priority = 3)
    public void dayDropDownTest(){
        //Select day using : index number
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByIndex(0);
        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(),"1");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }




}

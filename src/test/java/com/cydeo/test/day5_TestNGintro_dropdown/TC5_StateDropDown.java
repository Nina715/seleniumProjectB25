package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TC5_StateDropDown {
    WebDriver driver;
    //1. Open Chrome browser
    @BeforeMethod
    public void browserSetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void selectStateTask() {
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select stateDropDownSelect = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        stateDropDownSelect.selectByIndex(14);
        //4. Select Virginia
        stateDropDownSelect.selectByVisibleText("Virginia");
        //5. Select California
        stateDropDownSelect.selectByValue("CA");
        //6. Verify final selected option is California.
        String expectedOption = "California";
        Assert.assertTrue(stateDropDownSelect.getFirstSelectedOption().getText().equals(expectedOption));
        //Use all Select options. (visible text, value, index)
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

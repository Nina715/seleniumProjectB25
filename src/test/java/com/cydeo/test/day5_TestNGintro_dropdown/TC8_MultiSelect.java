package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC8_MultiSelect {
    WebDriver driver;
    Select languageMultiSelect;
    //1. Open Chrome browser
    @BeforeClass
    public void browserSetUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        languageMultiSelect = new Select(driver.findElement(By.cssSelector("select[name='Languages']")));
    }

    @Test (priority = 1)
    public void verifyMultiSelectOptions(){
        Assert.assertTrue(languageMultiSelect.isMultiple());
    }

    @Test (priority = 2)
    public void selectMultiple(){
        //3. Select all the options from multiple select dropdown.
        //4. Print out all selected values.
        List<WebElement> selectOptions = languageMultiSelect.getOptions();
        languageMultiSelect.selectByIndex(0);
        languageMultiSelect.selectByValue("js");
        languageMultiSelect.selectByVisibleText("C#");
        languageMultiSelect.selectByIndex(3);
        languageMultiSelect.selectByIndex(4);
        languageMultiSelect.selectByIndex(5);
        List<WebElement> selectedOptions= languageMultiSelect.getAllSelectedOptions();
        Assert.assertTrue(selectOptions.equals(selectedOptions));
        for (WebElement selectedOption : selectedOptions) {
            System.out.println("selected Options = " + selectedOption.getText());
        }
        languageMultiSelect.deselectAll();
    }

@AfterClass
    public void tearDown(){
        driver.close();
}

}

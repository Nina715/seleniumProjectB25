package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T4_ConfigPracticeGoogleSearch {

    /*WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
     */

    @Test
    public void google_search_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchTerm"), Keys.ENTER);
        String expectedTitle = "apple - Google Search";
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        Driver.getDriver().close();
    }
}

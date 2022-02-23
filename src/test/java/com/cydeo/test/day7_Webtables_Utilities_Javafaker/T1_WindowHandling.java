package com.cydeo.test.day7_Webtables_Utilities_Javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



//1. Create new test and make set ups
//2. Go to : https://www.amazon.com
    @Test
    public void windowHandleTest(){
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');"); // open tab
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');"); // open tab
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');"); // open tab
        Set <String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (driver.switchTo().window(windowHandle).getCurrentUrl().contains("etsy.com")){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains("Etsy"));
    }
//3. Copy paste the lines from below into your class
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
//4. Create a logic to switch to the tab where Etsy.com is open
//5. Assert: Title contains “Etsy”

    @AfterMethod
    public void TearDown(){
            driver.quit();
    }








}

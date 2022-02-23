package com.cydeo.test.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_Windows_Practice {
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set ups
    //3. Go to : https://practice.cydeo.com/windows
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/windows");
    }

    @Test
    public void windows_Test() {
        String mainHandle = driver.getWindowHandle();// storing main page's window handle as string is good practice for future reusable purposes
        Assert.assertTrue(driver.getTitle().equals("Windows"));//4. Assert: Title is “Windows”
        //5. Click to: “Click Here” link
        driver.findElement(By.xpath("//a[.='Click Here']")).click();



    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}

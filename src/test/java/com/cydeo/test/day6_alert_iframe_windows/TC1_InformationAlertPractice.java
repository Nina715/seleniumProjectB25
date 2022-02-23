package com.cydeo.test.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_InformationAlertPractice {
    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_Test1(){    //3. Click to “Click for JS Alert” button
        //4. Click to OK button from the alert
        //5. Verify “You successfully clicked an alert” text is displayed.
        driver.findElement(By.xpath("//buttton[.='Click for JS Alert']")).click();
        Alert informationAlert = driver.switchTo().alert();
        informationAlert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText=  "You successfully clicked an alert";
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        Assert.assertEquals(actualText,expectedText,"result text does not match expected text");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

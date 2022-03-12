package com.cydeo.test.day9_JavaFaker_TestBase_DriveUtil;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverPractice {
    @Test
    public void test1(){
        Driver.getDriver().get("https://google.ca");
        Driver.getDriver().findElement(By.name("q")).sendKeys("hello");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("hello - Google Search"));
        Driver.getDriver().close();
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://cydeo.com");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Cydeo"));
    }


}

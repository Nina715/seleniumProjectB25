package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2_Upload {
    @Test
    public void fileUpload(){
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.
        String filePath = "C:\\Users\\nigar\\OneDrive\\Desktop\\CY6-64 Expected.png";
        //3. Upload the file.
        Driver.getDriver().findElement(By.id("file-upload")).sendKeys(filePath);
        Driver.getDriver().findElement(By.cssSelector("input#file-submit")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //4. Assert:
        //-File uploaded text is displayed on the page
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h3")).isDisplayed());

    }
}

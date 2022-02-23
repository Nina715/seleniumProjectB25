package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second) {
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver,String expectedUrl,String expectedTitle){
        Set <String> windowHandles= driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (driver.switchTo().window(windowHandle).getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    public static void verifyTitle(WebDriver driver ,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

}

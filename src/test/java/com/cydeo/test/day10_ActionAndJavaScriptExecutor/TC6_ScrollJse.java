package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC6_ScrollJse {
    @Test
    public void scrollUsingJse(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        //3- Use below JavaScript method and scroll
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,750)");
        }

        //b.  750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-750)");
        }

        //JavaScript method to use : window.scrollBy(0,0)

    }
}

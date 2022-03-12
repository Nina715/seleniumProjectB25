package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC7_ScrollJse2 {
    @Test
    public void scrollViaJse2(){
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        //3- Scroll down to “Cydeo” link
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.linkText("CYDEO")));
        //4- Scroll up to “Home” link
        jse.executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.linkText("Home")));

        //5- Use below provided JS method only
    }
}

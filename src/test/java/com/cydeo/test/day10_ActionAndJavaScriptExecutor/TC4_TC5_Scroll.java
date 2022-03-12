package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC4_TC5_Scroll {
    @Test
    public void action_Scroll() {
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.=\"CYDEO\"]"))).perform();
        //5- Scroll back up to “Home” link using PageUP button
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
        }

    }


}

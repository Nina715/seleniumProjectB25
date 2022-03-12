package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_HoverOverTest {
    @Test
    public void mouseHoverOverTest(){
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers" );
        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"))).perform();
        //3. Assert:
        //a. “name: user1” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]//h5")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]//a")).isDisplayed());
        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displa
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"))).perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]//h5")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]//a")).isDisplayed());
        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"))).perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]//h5")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]//a")).isDisplayed());
    }
}

package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC8_DragAndDrop {
    @Test
    public void actionDragAndDrop(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
        BrowserUtils.sleep(10);
        //2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(Driver.getDriver().findElement(By.id("draggable")))
                .pause(2000).moveToElement(Driver.getDriver().findElement(By.id("droptarget"))).pause(2000).release().perform();
        //3. Assert:
        Assert.assertEquals(Driver.getDriver().findElement(By.id("droptarget")).getText(),"You did great!");
        //-Text in big circle changed to: “You did great!”
    }
}

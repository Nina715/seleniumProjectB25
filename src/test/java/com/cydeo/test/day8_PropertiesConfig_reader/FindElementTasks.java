package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementTasks extends TestBase {

    @Test(priority = 1)
    public void numberOfLinks() {
        driver.get("https://www.openxcell.com");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
        Assert.assertEquals(listOfLinks.size(), 325);
    }

    @Test(priority = 2)
    public void printLinkText() {
        driver.get("https://www.openxcell.com");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
        for (int i = 1; i <= listOfLinks.size(); i++) {
            System.out.println("Link text = " + driver.findElement(By.xpath("(//a)[" + i + "]")).getText());
        }
    }

    @Test(priority = 3)
    public void countingLinksWithNoText() {
        driver.get("https://www.openxcell.com");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
        int count = 0;
        for (int i = 1; i <= listOfLinks.size(); i++) {
            String actualLinkText = driver.findElement(By.xpath("(//a)[" + i + "]")).getText();
            if (actualLinkText.isEmpty()) {
                count++;
            }

        }
        Assert.assertTrue(count == 240,"actual count is "+count);
    }


}

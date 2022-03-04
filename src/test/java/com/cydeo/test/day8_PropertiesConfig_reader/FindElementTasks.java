package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementTasks {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

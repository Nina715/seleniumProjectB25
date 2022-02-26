package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //TC #1: Web table practice
    // 1. Go to: https://practice.cydeo.com/web-tables
    //2. Verify Bob’s name is listed as expected.
    //Expected: “Bob Martin”
    //3. Verify Bob Martin’s order date is as expected
    //Expected: 12/31/2021
    @Test
    public void order_name_verify_test() {
        driver.get("https://practice.cydeo.com/web-tables");
        WebElement pizzaOrderName = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        String actualName = pizzaOrderName.getText();
        String expectedName = "Bob Martin";
        Assert.assertEquals(actualName, expectedName);
        WebElement pizzaOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        String actualOrderDate = pizzaOrderDate.getText();
        String expectedOrderDate = "12/31/2021";
        Assert.assertEquals(actualOrderDate, expectedOrderDate);
    }

    @Test
    public void test2UsingWebTableUtils(){
        driver.get("https://practice.cydeo.com/web-tables");
        WebTableUtils.orderVerify(driver,"Alexandra Gray","04/15/2021");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}

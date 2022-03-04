package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void linkVerification() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<WebElement> linksList = driver.findElements(By.xpath("//a"));
        System.out.println("# of links = " + linksList.size());
        for (int i = 1; i < linksList.size(); i++) {
            System.out.println("link text= " + driver.findElement(By.xpath("(//a)[" + i + "]")).getText());
        }
    }

    @Test(priority = 2)
    public void orderPlacing(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginToSmartBear(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Order")).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByIndex(1);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        driver.findElement(By.xpath("(//input[@class='btn_dark'])[1]")).click();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode().replaceAll("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.business().creditCardNumber().replaceAll("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("05/22");
        driver.findElement(By.linkText("Process")).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String actualText = driver.findElement(By.xpath("//strong")).getText();
        Assert.assertTrue(actualText.equals("New order has been successfully added."),"actual message is not New order has been successfully added. it is: "+actualText);
    }

    @Test(priority = 3)
    public void orderVerification(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginToSmartBear(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("View all orders")).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String actualOrderDate=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]")).getText();
        Assert.assertTrue(actualOrderDate.equals("01/05/2010"),"Susan's actal order date is not 01/05/2010");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

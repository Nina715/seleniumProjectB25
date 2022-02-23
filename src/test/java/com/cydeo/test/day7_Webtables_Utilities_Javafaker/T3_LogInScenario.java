package com.cydeo.test.day7_Webtables_Utilities_Javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_LogInScenario {
    WebDriver driver;

    @DataProvider(name = "userName and password")
    public Object[][] userNameAndPsswrd(){
        return new Object[][]{
            {"helpdesk1@cybertekschool.com","UserUser"},{"helpdesk2@cybertekschool.com","UserUser"}
        };
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test (dataProvider = "userName and password")
    public void logInTest(String userName,String password) {
        driver.get("https://login1.nextbasecrm.com/");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox.sendKeys(userName);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(password, Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),"Portal");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
// Create new test and make set ups 
//2. Go to : http://login1.nextbasecrm.com/ 
//3. Enter valid username 
//4. Enter valid password 
//5. Click to `Log In` button 
//6. Verify title is as expected: 
//Expected: Portal 
// 
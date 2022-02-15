package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TestNG_Selenium {
    public WebDriver driver;

    @BeforeMethod // new browser should be opened before each test
    public void browserSet_Up() {
        //do browser driver set up
        //open browsert
        //maximize the page
        //implicit wait
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void selenium_test() {

        // get"https://google.com"
        driver.get("https://google.com");
        assertEquals(driver.getTitle(), "Google","Title is not matching"); // the message will only be displayed if the test failed, it wont be displayed otherwise
        // assert : title is "Google"
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}


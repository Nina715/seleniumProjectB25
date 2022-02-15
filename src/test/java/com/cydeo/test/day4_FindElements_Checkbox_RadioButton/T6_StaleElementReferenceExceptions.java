package com.cydeo.test.day4_FindElements_Checkbox_RadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceExceptions {
    public static void main(String[] args) {
        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeo = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']"));
        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
        //4- Refresh the page.
        driver.navigate().refresh();
        //5- Verify it is displayed, again.
        cydeo = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']")); // reassign(re-locate) the value after refreshing, after refreshing, connection is lost hence, must re-locate the elements
        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
        driver.close();

    }
}
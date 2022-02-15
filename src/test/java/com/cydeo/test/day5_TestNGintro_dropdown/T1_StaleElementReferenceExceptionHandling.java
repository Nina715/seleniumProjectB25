package com.cydeo.test.day5_TestNGintro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementReferenceExceptionHandling {
    public static void main(String[] args) {


        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElement.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement delete = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("delete.isDisplayed() after clicking addElement button = " + delete.isDisplayed());
        //5. Click to “Delete” button.
        delete.click();
        //6. Verify “Delete” button is NOT displayed after clicking.
        try{
            delete.isDisplayed();
        }catch (StaleElementReferenceException e){
            System.out.println("after clicking, delete.isDisplayed() = false");
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        driver.close();
    }
}

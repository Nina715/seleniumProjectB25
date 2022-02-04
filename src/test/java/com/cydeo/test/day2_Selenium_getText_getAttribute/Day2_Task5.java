package com.cydeo.test.day2_Selenium_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Task5 {
    public static void main(String[] args) throws InterruptedException {
        // initialize driver and open webpage
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //get to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //get header text
        WebElement headerTextElmt = driver.findElement(By.tagName("h2"));
        String headerTxt = headerTextElmt.getText();
        // verify if header text is as expeccted:
        if (headerTxt.equals("Registration form")){
            System.out.println("PASS! Actual header text matches expected header text");
        }else{
            System.out.println("FAIL! Actual header text does not match expected header text!");
        }

        //locate first name input box and get attribute value for placeholder
        WebElement firstNameInputBox = driver.findElement(By.name("firstname"));
        String attributeValue = firstNameInputBox.getAttribute("placeholder");

        //verify if attribute value matches expected
        if (attributeValue.equals("first name")){
            System.out.println("PASS! Attribute value of place holder matches the expected value");
        }else{
            System.out.println("FAIL! Attribute value of place holder DOES NOT match the expected value");
        }

        Thread.sleep(1000);
        driver.close();

    }
}
/*
//3- Verify header text is as expected:
        //Expected: Registration form
        //4- Locate “First name” input box
        //5- Verify placeholder attribute’s value is as expected: Expected: first name
 */
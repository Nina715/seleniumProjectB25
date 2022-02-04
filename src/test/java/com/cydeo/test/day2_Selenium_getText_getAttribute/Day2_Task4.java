package com.cydeo.test.day2_Selenium_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Task4 {
    public static void main(String[] args) throws InterruptedException {
        //initializing and opening driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to page "http://library2.cybertekschool.com/login.html"
        driver.get("http://library2.cybertekschool.com/login.html");

        //get the username box by className
        WebElement usernameBox = driver.findElement(By.className("form-control"));

        //input invalid@cydeo.com to username box
        usernameBox.sendKeys("invalid@cydeo.com");

        // get the password box by id
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));

        //input password "incorrect password"
        passwordBox.sendKeys("incorrect password");

        //locate submit box via tag name and click submit
        WebElement submitBox = driver.findElement(By.tagName("button"));
        submitBox.click();

        Thread.sleep(1000);

        driver.close();

    }
}

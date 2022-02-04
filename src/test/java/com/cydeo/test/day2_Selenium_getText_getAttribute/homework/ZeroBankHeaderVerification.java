package com.cydeo.test.day2_Selenium_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {
    public static void main(String[] args) throws InterruptedException {
        // initialize and open web-browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //get WebElement -header
        WebElement header = driver.findElement(By.tagName("h3"));

        //get text from element
        String headerText = header.getText();

        //verification
        if (headerText.equals("Log in to ZeroBank")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(1000);
        driver.close();
    }
}
//TC #2: Zero Bank header verification
//1. Open Chrome browser
//2. Go to http://zero.webappsecurity.com/login.html
//3. Verify header text
//Expected: “Log in to ZeroBank”
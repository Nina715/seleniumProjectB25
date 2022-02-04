package com.cydeo.test.day2_Selenium_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Task1 {
    public static void main(String[] args) throws InterruptedException {
        //initialize webdirver
        WebDriverManager.chromedriver().setup();

        //assign driver and open webpage
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //get URL
        String currentURL = driver.getCurrentUrl();

        //get title
        String title = driver.getTitle();

        //verify if URL contains"cydeo"
        if (currentURL.contains("cydeo")) {
            System.out.println("URL contains expected value: Pass");
        } else {
            System.out.println("URL does not contain expected value: Fail");
        }

        if (title.equals("Practice")) {
            System.out.println("verify title against expected value: Pass");
        } else {
            System.out.println("verify title against expected value: Fail");
        }

        Thread.sleep(3000);
        //close webpage
        driver.close();
    }
}

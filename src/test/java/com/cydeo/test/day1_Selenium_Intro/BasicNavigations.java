package com.cydeo.test.day1_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException{
        // 1 - set up the browser driver
        WebDriverManager.chromedriver().setup();

        // 2 - Create instance of the driver
        WebDriver driver= new ChromeDriver(); //empty browser will be opened


        // 3 - Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //stop code execution for 3 seconds;
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //use selenium to navigate back, it goes to tesla.com first then navigate back to empty page
        driver.navigate().back();
        Thread.sleep(3000);

        //use selenium to navigate forward, it goes back to empty page first then navigate forward to tesla.com
        driver.navigate().forward();

        Thread.sleep(3000);//not the best way but could be used for now
        //refresh the page
        driver.navigate().refresh();

        //navigate to a new URL google.com, same as driver.get method
        driver.navigate().to("https://google.com");

        Thread.sleep(3000);
        // get title of the page
        System.out.println(driver.getTitle()); // need to assign it to a variable
        System.out.println(driver.getCurrentUrl());

        driver.close();

    }
}

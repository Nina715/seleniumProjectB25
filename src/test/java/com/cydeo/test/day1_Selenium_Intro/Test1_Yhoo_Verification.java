package com.cydeo.test.day1_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_Yhoo_Verification {
    public static void main(String[] args) throws InterruptedException{
        //TC #1: Yahoo Title Verification -> set up browser driver
        WebDriverManager.chromedriver().setup();

        //1.Open Chrome browser
        WebDriver driver = new ChromeDriver();
        // maximize pg
        driver.manage().window().maximize();
        //2.Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");
        //3.Verify title: get title
        String title = driver.getTitle();
        //ExpectedYahoo
        System.out.println("title is Yahoo: "+ title.equals("Yahoo"));
        Thread.sleep(2000);
        if (!title.equals("Yahoo")){
            System.out.println("title of this page is = " + title);
        }
        driver.close();


    }
}

package com.cydeo.test.day2_Selenium_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {
    public static void main(String[] args) throws InterruptedException {
        //opening webpage
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to https://google.com
        driver.get("https://google.com");

        // click web element gmail
        driver.findElement(By.className("gb_d")).click();

        //get current title
        String currentTitle = driver.getTitle();
        if (currentTitle.contains("Gmail")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        //go back to google and get title
        driver.navigate().back();
        currentTitle = driver.getTitle();

        if (currentTitle.equals("Google")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(1000);
        driver.close();

    }

}

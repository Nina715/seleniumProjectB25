package com.cydeo.test.day2_Selenium_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCydeo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com/inputs");
        //get web-element
        WebElement homeButton = driver.findElement(By.className("nav-link"));
        homeButton.click();

        String currentTitle = driver.getTitle();
        if (currentTitle.equals("Practice")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        Thread.sleep(1000);
        driver.close();
    }
}

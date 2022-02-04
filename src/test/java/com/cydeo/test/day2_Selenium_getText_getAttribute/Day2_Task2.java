package com.cydeo.test.day2_Selenium_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Task2 {
    //initiate webdriver
    public static void main(String[] args) throws InterruptedException {
        //open a chrome browser and navigate to the target website "https://practice.cydeo.com"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cydeo.com");
        Thread.sleep(1000);
        WebElement linkText1 = driver.findElement(By.linkText("A/B Testing"));
        linkText1.click();
        String currentTitle = driver.getTitle();
        if (currentTitle.equals("No A/B Test")){
            System.out.println("title verification of current pg: pass");
        } else{
            System.out.println("title verification of current pg: fail");
        }
        Thread.sleep(1000);
        driver.navigate().back();
        currentTitle = driver.getTitle();
        if (currentTitle.equals("Practice")){
            System.out.println("title verification of current pg: pass");
        } else{
            System.out.println("title verification of current pg: fail");
        }
        Thread.sleep(1000);
        driver.close();

    }
}

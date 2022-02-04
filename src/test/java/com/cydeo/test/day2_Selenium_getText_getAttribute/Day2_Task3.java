package com.cydeo.test.day2_Selenium_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Task3 {
    public static void main(String[] args) {
        //set up browser and open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // go to https://google.com/
        driver.get("https://google.com/");

        //find search box element:
        WebElement searchBox = driver.findElement(By.name("q"));

        //input apple in search box
        searchBox.sendKeys("apple");

        //find search button element
        WebElement searchButton = driver.findElement(By.name("btnK"));

        //click search
        searchButton.click();

        //display result against Expected: Title should start with “apple” word
        String currentTitle = driver.getTitle();
        if (currentTitle.startsWith("apple")){
            System.out.println("PASS! Title start with apple.");
        } else{
            System.out.println("FAIL! Title does not start with apple!");
        }
    }
}
/*
TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com/
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word
 */
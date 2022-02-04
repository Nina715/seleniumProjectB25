package com.cydeo.test.day2_Selenium_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        //initiate and open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //get to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //find element by id
        WebElement searchbox = driver.findElement(By.id("global-enhancements-search-query"));

        //search "woodenspoon"
        searchbox.sendKeys("wooden spoon" );

        String currentTitle = driver.getTitle();
        WebElement searchbutton = driver.findElement(By.className("wt-input-btn-group__btn global-enhancements-search-input-btn-group__btn"));
        searchbutton.click();
        //verify title if the actual title matches expected title "Wooden spoon | Etsy"
        if (currentTitle.equals("Wooden spoon | Etsy CA")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        Thread.sleep(1000);
        driver.close();
    }
}

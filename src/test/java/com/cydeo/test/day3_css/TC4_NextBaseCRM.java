package com.cydeo.test.day3_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_NextBaseCRM {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Verify “Reset password” button text is as expected:
        String resetPasswordText = driver.findElement(By.cssSelector("button.login-btn")).getAttribute("value");
        //Expected: Reset password
        String expectedMsg = "Reset password";
        if (resetPasswordText.equals(expectedMsg)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.close();
    }
}


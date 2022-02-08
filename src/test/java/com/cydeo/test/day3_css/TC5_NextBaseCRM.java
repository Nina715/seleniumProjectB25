package com.cydeo.test.day3_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_NextBaseCRM {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");
        //3- Enter incorrect username into login box:
        driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        //4- Click to `Reset password` button
        driver.findElement(By.className("login-btn")).click();
        //5- Verify “error” label is as expected
        String errorMsg = driver.findElement(By.className("errortext")).getText();
        //Expected: Login or E-mail not found
        String expectedMsg = "Login or E-mail not found";
        if (errorMsg.equals(expectedMsg)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.close();
    }
}

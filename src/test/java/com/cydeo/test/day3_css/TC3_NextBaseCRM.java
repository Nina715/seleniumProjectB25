package com.cydeo.test.day3_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_NextBaseCRM {
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        String logIn = driver.findElement(By.cssSelector("input[type='submit']")).getAttribute("value");
        //Expected: Log In
        String expectedLogIn = "Log In";
        if (logIn.equals(expectedLogIn)){
            System.out.println("log in pass");
        }else{
            System.out.println("log in fail");
        }
        Thread.sleep(1000);
        driver.close();
    }
}

package com.cydeo.test.day3_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_NextBaseCRM {
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/ ");
        //3- Verify “remember me” label text is as expected:
        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String labelText = rememberMe.getText();
        //Expected: Remember me on this computer
        String expectedText = "Remember me on this computer";
        if (labelText.equals(expectedText)){
            System.out.println("remember me label text pass");
        }else{
            System.out.println("expectedText = " + expectedText);
            System.out.println("rememberMe = " + rememberMe);
            System.out.println("remember me label text fail");
        }
        //4- Verify “forgot password” link text is as expected:
        String forgotPasswordText = driver.findElement(By.className("login-link-forgot-pass")).getText();
        //Expected: Forgot your password?
        String expectedTxt = "Forgot your password?";
        if (forgotPasswordText.equals(expectedTxt)){
            System.out.println("forgot your password text pass");
        }else{
            System.out.println("expectedTxt = " + expectedTxt);
            System.out.println("forgotPasswordText = " + forgotPasswordText);
            System.out.println("forgot your password text fail");
        }
        //5- Verify “forgot password” href attribute’s value contains expected:
        String hrefValue = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        //Expected: forgot_password=yes
        String expectedHrefValue = "forgot_password=yes";
        if (hrefValue.contains(expectedHrefValue)){
            System.out.println("HREF attribute value pass");
        } else{
            System.out.println("expectedHrefValue = " + expectedHrefValue);
            System.out.println("hrefValue = " + hrefValue);
            System.out.println("HREF attribute value fail");
        }

        Thread.sleep(1000);
        driver.close();
    }
}

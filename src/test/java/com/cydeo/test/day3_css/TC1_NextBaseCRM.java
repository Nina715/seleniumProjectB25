package com.cydeo.test.day3_css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_NextBaseCRM {
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Enter incorrect username: “incorrect”
        WebElement userNameSlot = driver.findElement(By.name("USER_LOGIN"));
        userNameSlot.sendKeys("incorrect");
        //4- Enter incorrect password: “incorrect”
        WebElement passwordSlot = driver.findElement(By.name("USER_PASSWORD"));
        passwordSlot.sendKeys("incorrect");
        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        //6- Verify error message text is as expected:
        WebElement errormsg = driver.findElement(By.className("errortext"));
        String errorMessage = errormsg.getText();
        //Expected: Incorrect login or password
        String expectedError = "Incorrect login or password";
        if (errorMessage.equals(expectedError)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        Thread.sleep(1000);
        driver.close();
    }
}

package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){
        if (browserType.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Given browser type does not exist or is not currently available\ndriver=null.");
            return null;
        }
    }
}

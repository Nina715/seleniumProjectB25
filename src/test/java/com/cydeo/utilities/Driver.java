package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //creating a private constructor so we are restricting access to the object of this class from outside class

    private Driver() {
    }

    //make webdriver private, because we want to restrict access from outside the class
    //we make it static because we will use it in a static method, static belongs to the class and it will run before anything else
    private static WebDriver driver;

    //create a re-usable utility method which will return the same driver instance when we call it
    public static WebDriver getDriver() {
        if (driver == null) {

            //we read our browserType from configuraion.properties, this way, we can control which browser is open from outside our code
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }


        }
        return driver;
    }
    /*
  This method will make sure our driver value is always null after using quit() method
   */
    public static void closeDriver(){
        if (driver != null){
            driver.quit(); // this line will terminate the existing session. value will not even be null
            driver = null;
        }
    }
}

package com.cydeo.test.day4_FindElements_Checkbox_RadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_FindElements {
    public static void main(String[] args) {
//TC #4: FindElements Task
//1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//providing etra wait time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest ");
//3- Locate all the links in the page.
        List<WebElement> links = driver.findElements(By.tagName("a"));

//4- Print out the number of the links on the page.
        System.out.println("links.size() = " + links.size());

//5- Print out the texts of the links.
        for (WebElement link : links) {
            System.out.println("link.getText() = " + link.getText());
        }
//6- Print out the HREF attribute values of the links

        for (WebElement link : links) {
            System.out.println("link.getAttribute(\"href\") = " + link.getAttribute("href"));
        }

    }
}

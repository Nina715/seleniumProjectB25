package com.cydeo.test.day4_FindElements_Checkbox_RadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {
        ///DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //        //TC #1: XPATH and cssSelector Practices
        //        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //        //locator only (total of 6)
        //        //Locate homeLink using cssSelector, class value
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        //        //Locate homeLink using cssSelector syntax #2
        homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //        //Locate homeLink using cssSelector, href value
        homeLink = driver.findElement(By.cssSelector("a[href = '/']"));

        //        //b. “Forgot password” header
        //        //Locate header using cssSelector: locate parent element and move down to h2
        WebElement header = driver.findElement(By.cssSelector("div.example>h2"));

        //        //Locate header using xpath, and using web elements text "Forgot Password"
        header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //        //c. “E-mail” text
        WebElement email = driver.findElement(By.cssSelector("div.large-6.small-12.columns>label"));//"label[for='email']";
        email = driver.findElement(By.xpath("//label[@for='email']")); //or //div[.='large-6 small-12 columns']/label or //label

        //        //d. E-mail input box
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']")); //or div.large-6 small-12 columns>input

        //        //Locate inputBox using xpath contains method
           emailInput = driver.findElement(By.xpath("//input")); //or//input[@type='text'];// or input[contains(@pattern='a-z0-9]);
        //        //tagName[contains(@attribute,'value')]

        //        //e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.cssSelector("i.icon-2x.icon-signin"));// button.radius>i;
        retrievePassword = driver.findElement(By.xpath("//i"));// //i

        //        //f. “Powered by Cydeo text
        //WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style='text-align: center;")); // div.large-4 large-centered columns>div
        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[contains (@style,'text-align')]"));
        //        //4. Verify all web elements are displayed.

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("header.isDisplayed() = " + header.isDisplayed());
        System.out.println("email.isDisplayed() = " + email.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());



    }
}

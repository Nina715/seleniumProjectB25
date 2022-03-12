package com.cydeo.test.day10_ActionAndJavaScriptExecutor;

import com.cydeo.test.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_RegistrationFormCompeletion extends TestBase {
    @Test
    public void registrationFormCompeletion(){
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Faker faker = new Faker();
        driver.get("https://practice.cydeo.com/registration_form");
        //3. Enter first name

        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        //4. Enter last name
          driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        //5. Enter username
        driver.findElement(By.cssSelector("#registrationForm > div:nth-child(3) > div > input")).sendKeys(faker.bothify("?????###"));
        //6. Enter email address
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(faker.internet().emailAddress());
        //7. Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.bothify("????###-??"));
        //8. Enter phone number
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("###-###-####"));
        //9. Select a gender from radio buttons
        driver.findElement(By.xpath("//input[@value='female']")).click();
        //10. Enter date of birth

        driver.findElement(By.name("birthday")).sendKeys("07/15/1992");
        //11. Select Department/Office
        Select select = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        select.selectByIndex(2);
        //12. Select Job Title
        new Select(driver.findElement(By.name("job_title"))).selectByVisibleText("SDET");
        //13. Select programming language from checkboxes
        driver.findElement(By.cssSelector("input#inlineCheckbox2")).click();
        //14. Click to sign up button
        driver.findElement(By.cssSelector("button#wooden_spoon")).click();
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
        Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(),"You've successfully completed registration!");


    }
}

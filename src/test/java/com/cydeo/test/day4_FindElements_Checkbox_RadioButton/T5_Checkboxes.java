package com.cydeo.test.day4_FindElements_Checkbox_RadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T5_Checkboxes {
    public static void main(String[] args) {

        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        //WebElement checkbox1 = driver.findElement(By.id("box1"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int i=1;
        for (WebElement checkbox : checkboxes) {
            System.out.println("checkbox #"+i+ " is selected = " + checkbox.isSelected());
            checkbox.click();
            System.out.println("after clicking, checkbox #"+i+" is selected =" +checkbox.isSelected());
            i++;
        }
        //WebElement checkbox1 = driver.findElement(By.cssSelector("input#box1"));
        //System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        //WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
       // System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //4. Click checkbox #1 to select it.
        //checkbox1.click();

        //5. Click checkbox #2 to deselect it.
       // checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        //System.out.println("after clicking checkbox1.isSelected() = " + checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        //System.out.println("after clicking checkbox2.isSelected() = " + checkbox2.isSelected());

        driver.close();

    }
}

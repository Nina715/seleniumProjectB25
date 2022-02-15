package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickAndVerifyRadioButtn {

    //Create a utility method to handle above logic.
    //Method name: clickAndVerifyRadioButton
    //Return type: void or boolean
    //Method args:
    //1. WebDriver
    //2. Name attribute as String (for providing which group of radio buttons)
    //3. Id attribute as String (for providing which radio button to be clicked)
    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idAttributeValue) {
        //Method should loop through the given group of radio buttons. When it finds the
        //List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@"+attribute+"='"+attributeValue+"']"));
        //List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@type='radio']")); //<-- Work to verify all radiobuttons on page
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));
        //matching option, it should click and verify option is Selected.
        //Print out verification: true
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("id").equalsIgnoreCase(idAttributeValue)) {
                radioButton.click();
                System.out.println(idAttributeValue + " is selected after clicking = " + radioButton.isSelected());
                break;
            }
        }
    }

    /* TEST

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        clickAndVerifyRadioButton(driver,"color","blue");
    }

     */


}

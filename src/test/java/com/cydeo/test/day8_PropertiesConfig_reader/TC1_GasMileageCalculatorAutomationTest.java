package com.cydeo.test.day8_PropertiesConfig_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TC1_GasMileageCalculatorAutomationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //chrome browser set up
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void gasMileageCalcTest(){
        //Go to https://www.calculator.net
        driver.get("https://www.calculator.net");
        //Search for “gas mileage” using search box
        driver.findElement(By.xpath("//input[@id='calcSearchTerm']")).sendKeys(ConfigurationReader.getProperty("calculatorSearchBox"));
        //click search button
        driver.findElement(By.id("bluebtn")).click();
        //clicking the gas mileage calculator link
        driver.findElement(By.linkText("Gas Mileage Calculator")).click();
        //waiting for page to load
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //verify Title
        assertEquals(driver.getTitle(),"Gas Mileage Calculator","actual title does not match expected title");
        //verify label
        String actualLabelText = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']")).getText();//h1[.='Gas Mileage Calculator']
        assertTrue(actualLabelText.equals("Gas Mileage Calculator"),"Actual label text does not equal to expected label text");
        //Locate, clear and type “7925” into “Current odometer” field
        driver.findElement(By.id("mucodreading")).clear();
        driver.findElement(By.id("mucodreading")).sendKeys(ConfigurationReader.getProperty("currentOdometer"));
        //Locate, clear and type “7550” into “Previous odometer” field
        driver.findElement(By.id("mupodreading")).clear();
        driver.findElement(By.id("mupodreading")).sendKeys(ConfigurationReader.getProperty("previousOdometer"));
        //Locate, clear and type “16” into “Gas added” field
        driver.findElement(By.xpath("//input[@id='mugasputin']")).clear();
        driver.findElement(By.id("mugasputin")).sendKeys(ConfigurationReader.getProperty("gasAdded"));
        //Locate, clear and type “3.55” into “Gas price” field
        driver.findElement(By.cssSelector("input#mugasprice")).clear();
        driver.findElement(By.cssSelector("input#mugasprice")).sendKeys(ConfigurationReader.getProperty("gasPrice"));
        //Click on Calculate button
        driver.findElement(By.xpath("(//input[@value='Calculate'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //Verify mpg value is as expected value: “23.44 mpg”
        String actualMpgValue = driver.findElement(By.className("bigtext")).getText();
        assertTrue(actualMpgValue.equals("23.44 mpg"),"actual mpg value does not match expected value 23.44 mpg");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

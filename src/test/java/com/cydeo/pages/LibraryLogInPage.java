package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLogInPage {
    public LibraryLogInPage(){
        //create connection in between th current driver session(instance) and the object of the current class
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //2. use @FindBy annotation to locate elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUserName;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[.='This field is required.']")
    public WebElement fieldRequiredErrorMsg;

    @FindBy (xpath = "//div[.='Please enter a valid email address.']")
    public WebElement InvalidEmailAddressError;

    @FindBy (xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrMsg;

}

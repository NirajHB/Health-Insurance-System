package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPomPage {
 private WebDriver driver;
 
 
 //Email Or Phone Number Element
 @FindBy(xpath="//input[@id='ap_email']")
 WebElement emailOrPhoneNo;
 public void sendEmailOrPhoneNo(String emailPhoneno) {
	 emailOrPhoneNo.sendKeys(emailPhoneno);
 }
 
 //Continue button
 @FindBy(xpath="//input[@id='continue']")
 WebElement contiunueButton;
 public void clickOncontinueButton() {
	 contiunueButton.click();
 }
 
 
 //password text box
 @FindBy(xpath="//input[@id='ap_password']")
 WebElement passwordtxt;
 public void sendPassowrd(String password) {
	 passwordtxt.sendKeys(password);
 }
 
 //sign in button
 @FindBy(xpath="//input[@id='signInSubmit']")
 WebElement signInButton;
 public void clickOnSignInButton() {
	 signInButton.click();
 }
 
 
 
 
 
 
 
 //Constructor
 public SignInPomPage(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
 }
 
 
 
 
 
}

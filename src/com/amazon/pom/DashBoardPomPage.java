package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPomPage {
   private WebDriver driver;

//sign in Element
   @FindBy(xpath="//a[@id='nav-link-accountList']")
   WebElement signIn;
   public void clickedInSignInButton() {
	   signIn.click();
   }
   
 //Account and list tab
   @FindBy(xpath="//a[@id='nav-link-accountList']")
   WebElement accountAndList;
   public void accountAndListMethod() {
	   Actions actions  = new Actions(driver);
	   actions.clickAndHold(accountAndList).perform();
	   }
   
// sign out
   @FindBy(xpath="//span[text()='Sign Out']")
   WebElement signOutOption;
   public void clickedOnSignOut() {
	   signOutOption.click();
   }
   
 //search Box  
   @FindBy(xpath="//input[@id='twotabsearchtextbox']")
   WebElement searchBoxTxt;
   public void sendSearchBox(String search) {
	   searchBoxTxt.sendKeys(search);
   }
   
   //search Icon
   @FindBy(xpath="//input[@id='nav-search-submit-button']")
   WebElement searchIcon;
   public void ClickedSearchIcon() {
	   searchIcon.click();
   }
   
   //samsung s20 add to cart
   @FindBy(xpath="//input[@id='add-to-cart-button']")
   WebElement addtocart;
   public void clickedS20AddtoCart() {
	   addtocart.click();
   }
   
   
   
 //Constructor
   public DashBoardPomPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   
}

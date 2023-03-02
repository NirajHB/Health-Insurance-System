package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPomClass {
    private WebDriver driver;
    
    @FindBy(xpath="(//span[text()='Samsung Galaxy S20 FE 5G (Cloud Mint, 8GB RAM, 128GB Storage)'])[2]")
    WebElement samsungS20;
    public void clickedOnsamsungS20() {
    	samsungS20.click();
    }
    
    
    
    
    
    
    
    
    
    public SearchPomClass(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    
    
    
}

package com.amazon.dom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TC_04_ItemAddToCart {

static WebDriver driver;
	public static void screenShot(String filename) throws IOException {
		    TakesScreenshot ts=(TakesScreenshot)driver;                
		       File source=ts.getScreenshotAs(OutputType.FILE);
		       File desti =new File("D:\\Screen Shots\\Amazon\\TC_04_ItemAddToCart\\"+filename+".jpg");
		       FileHandler.copy(source, desti);
		
	}
    public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		
	   driver = new ChromeDriver();
	  System.out.println("Open Browser");
	  driver.get("https://www.amazon.in/");
	  System.err.println("Open Url");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  Thread.sleep(5000);
	  screenShot("LoginPage");
	  driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
       System.out.println("Clicked on Login Button");
         driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("9403474978");       
         System.out.println("Enter Username");
         
         driver.findElement(By.xpath("//input[@id='continue']")).click();
         System.out.println("Clicked on Contiunue Button");

         driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("nirajb");
         System.out.println("Enter Password");

         driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
         System.out.println("Clicked on Submit Button");
        Thread.sleep(4000);
        screenShot("HomePage");

         driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
         System.out.println("Enter Value in search Box ");
    
         driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
       System.out.println("Clicked on Search button");
         Thread.sleep(4000);
         screenShot("SearchFunctionality");
   
          driver.findElement(By.xpath("(//span[text()='Samsung Galaxy S20 FE 5G (Cloud Mint, 8GB RAM, 128GB Storage)'])[1]")).click();
          System.out.println("clicked on samsung galaxy s20 mobile");
        
          List<String> allPagesAddr= new ArrayList<String>(driver.getWindowHandles());
                        driver.switchTo().window(allPagesAddr.get(1));
                        System.out.println("switching new tab");
          Thread.sleep(4000);
          screenShot("samsung galaxy s20");
    
         driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
         System.out.println("Clicked on add to cart button");
         Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@class='a-button-input'])[34]")).click();
          
          System.out.println("Clicked to cart for go to cart");
          Thread.sleep(4000);
          screenShot("Cart");
          
    
    }
}
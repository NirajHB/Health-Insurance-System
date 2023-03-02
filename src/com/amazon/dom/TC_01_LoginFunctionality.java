package com.amazon.dom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TC_01_LoginFunctionality {
	static WebDriver driver;
	
	
	public static void screenShot(String filename) throws IOException {
		    TakesScreenshot ts=(TakesScreenshot)driver;                
		       File source=ts.getScreenshotAs(OutputType.FILE);
		       File desti =new File("D:\\Screen Shots\\Amazon\\TC_01_LogIn\\"+filename+".jpg");
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
        System.out.println("************** validation *****************");
        String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual = driver.getTitle();
    if (expected.equals(actual)) {
		System.out.println("TC_01_LoginFunctionality is Passed ");
	} else {
      System.out.println("TC_01_LoginFunctionality is Failed");
	}
    
    
    }
}

package com.amazon.dom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class TC_02_LogOutFunctionality {
static WebDriver driver;
	
	
	public static void screenShot(String filename) throws IOException {
		    TakesScreenshot ts=(TakesScreenshot)driver;                
		       File source=ts.getScreenshotAs(OutputType.FILE);
		       File desti =new File("D:\\Screen Shots\\Amazon\\TC_02_LogOutFunctionality\\"+filename+".jpg");
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

        System.out.println("*************** Log out Code****************");
               WebElement account=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
               WebElement signOut = driver.findElement(By.xpath("//span[text()='Sign Out']"));
               Actions actions = new Actions(driver);
                 actions.clickAndHold(account).perform();
                 System.out.println("Move cursor on account");
                 actions.click(signOut).perform();
                 System.out.println("Clicked On SignOut");
                Thread.sleep(4000);
                screenShot("LogOutPage");
         System.out.println("End of Programme");
    
    
    }
}
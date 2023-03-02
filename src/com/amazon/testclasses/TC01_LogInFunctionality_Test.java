package com.amazon.testclasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.pom.DashBoardPomPage;
import com.amazon.pom.SignInPomPage;
import com.amazon.utilityclasses.ScreenShotUtilityClass;

public class TC01_LogInFunctionality_Test {
	WebDriver driver ;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
	     driver = new ChromeDriver();
		System.out.println("Open Browser");
		          driver.navigate().to("https://www.amazon.in/");
		          System.out.println("Open Url");
	              driver.manage().window().maximize();
	              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		          
	//LogIn Functionality********************************************************
	              System.out.println("*********LogIn Functionality********** ");
	              DashBoardPomPage dp =new DashBoardPomPage(driver);
	              dp.clickedInSignInButton();
		          System.out.println("Clicked on Sign in Button");
		          
	             SignInPomPage sg= new SignInPomPage(driver);
	             sg.sendEmailOrPhoneNo("9403474978");
	             System.out.println("Enter email or phone number");
	             sg.clickOncontinueButton();
	             System.out.println("clicked on continue button");
	             sg.sendPassowrd("nirajb");
	             System.out.println("enter password ");
	             sg.clickOnSignInButton();
	             System.out.println("clicked on sign in button");

	             Thread.sleep(5000);
	            //take screenShot
	             System.out.println("*****Take Screenshot****");
	           // ScreenShotUtilityClass screenShotUtilityClass =new  ScreenShotUtilityClass(driver);
	           // screenShotUtilityClass.captureScreenShot("TC01_Login");
	             ScreenShotUtilityClass.captureScreenShot(driver);
	}
// validation****************************************************************         
	@Test 
	public void verifyLoginFunctionality() throws InterruptedException {
          System.out.println("********** validation ***************");
          
          String expected ="https://www.amazon.in/?ref_=nav_ya_signin";
          Thread.sleep(3000);
          String actual =driver.getCurrentUrl();
          if (expected.equals(actual)) {
				System.out.println(" TC01 test case is passed ");
			} else {
            System.out.println(" TC01 test case is Failed ");
			}
      }
      @AfterMethod       
     public void tearDown() {
    	 driver.close();
     }
             
 
}

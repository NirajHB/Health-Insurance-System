package com.amazon.testclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.pom.DashBoardPomPage;
import com.amazon.pom.SignInPomPage;

public class TC02_LogOutFunctionality_Tes {
    
	@Test
	public void LogoutFunctionality() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open Browser");
		          driver.navigate().to("https://www.amazon.in/");
		          System.out.println("Open Url");
	              driver.manage().window().maximize();
	              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		          
		 //LogIn Functionality
	              System.out.println("*********LogIn Functionality********** ");
	              DashBoardPomPage dp =new DashBoardPomPage(driver);
	              dp.clickedInSignInButton();
		          System.out.println("Clicked on Sign in Button");
		          
	             SignInPomPage sg= new SignInPomPage(driver);
	             sg.sendEmailOrPhoneNo("9403474978");
	             System.out.println("Enter email or phone number");
	             sg.clickOncontinueButton();
	             System.out.println("clicked on login button");
	             sg.sendPassowrd("nirajb");
	             System.out.println("enter password ");
	             sg.clickOnSignInButton();
	             System.out.println("clicked on sign in button");
	             
	  //Log Out Functionality           
	             System.out.println("*********LogOut Functionality**********");
                dp.accountAndListMethod();
                System.out.println("move over on account and list");
                dp.clickedOnSignOut();
               System.out.println("clicked on sign out button");
 
 System.out.println("************ validation **************");
 String expexcted = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
  Thread.sleep(4000);
 String actual =driver.getCurrentUrl();
 
 if (expexcted.equals(actual)) {
	System.out.println("TC 02 is passed ");
} else {
    System.out.println("TC 02 is Failed ");
}
 
 
 
 
 
 
 
 }
}


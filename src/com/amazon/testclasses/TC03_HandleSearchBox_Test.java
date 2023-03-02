package com.amazon.testclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.pom.DashBoardPomPage;
import com.amazon.pom.SignInPomPage;

public class TC03_HandleSearchBox_Test {
 
	@Test
	public void HandleSearchBox() {
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
//Enter Search Box value
	             dp.sendSearchBox("mobiles");
	             System.out.println("Enter value into search box ");
	             dp.ClickedSearchIcon();
	             System.out.println("Clicked on search icon");
	             
	             System.out.println("********* validation ***********");
	             
	             String expected = "Amazon.in : mobiles";
	             String actual = driver.getTitle();
	             if (expected.equals(actual)) {
					System.out.println(" TC03 is passed ");
				} else {
                   System.out.println(" TC03 is Failed ");
				}
	             
	             
	             
	             
	             
	             
}
}

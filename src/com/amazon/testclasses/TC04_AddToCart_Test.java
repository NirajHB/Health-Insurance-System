package com.amazon.testclasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.pom.DashBoardPomPage;
import com.amazon.pom.SearchPomClass;
import com.amazon.pom.SignInPomPage;

public class TC04_AddToCart_Test {

	@Test
	public void AddToCartProduct() {
	System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		          WebDriver driver = new ChromeDriver();
		            System.out.println("Open Browser");
		              driver.navigate().to("https://www.amazon.in/");
		             System.out.println("Open Url");
	                 driver.manage().window().maximize();
	                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		          
 //LogIn Functionality----------------------------------------------------------------
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
//Enter Search Box value-----------------------------------------------------------------------
	             dp.sendSearchBox("mobiles");
	             System.out.println("Enter value into search box ");
	             dp.ClickedSearchIcon();
	             System.out.println("Clicked on search icon");
	             
	             
               SearchPomClass class1 = new SearchPomClass(driver);
                              class1.clickedOnsamsungS20();


 //handle new window
                            List<String> allWindows=new ArrayList<String>
                            		(driver.getWindowHandles());
                                        driver.switchTo().window(allWindows.get(1));
                        System.out.println("Switch to another window");

                          dp.clickedS20AddtoCart();
                          System.out.println("Samsung S20 is addded into cart");
                                        
                                  
}
}

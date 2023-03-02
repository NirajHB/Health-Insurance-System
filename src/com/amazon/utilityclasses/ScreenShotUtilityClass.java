package com.amazon.utilityclasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class ScreenShotUtilityClass {
    
     public static void captureScreenShot(WebDriver driver) throws IOException, InterruptedException {
         TakesScreenshot  ts=(TakesScreenshot)driver;
         Thread.sleep(4000);
    	       File source = ts.getScreenshotAs(OutputType.FILE);
    	       File destination=new File("D:\\Screen Shots\\Pom\\SauceDemo\\Amazon.jpg");
    	       FileHandler.copy(source, destination);
     }
     
   
     
}

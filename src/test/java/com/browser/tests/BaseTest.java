package com.browser.tests;


import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.opera.core.systems.OperaDriver;


public abstract class BaseTest {
	 
	  WebDriver driver;
	  
	  protected StringBuffer verificationErrors = new StringBuffer();
	  protected String baseUrl;
	
	  
	  @BeforeTest
	  @Parameters ({"browser"})
	  public void setUp(@Optional ("firefox")String browser)  {
	    if (browser.equals("firefox")) {
	    	driver = new FirefoxDriver();
	    	
	    } else if (browser.equals("chrome")) {
	    	driver = new ChromeDriver();
	    	
	    } else if (browser.equals("ie")) {
	    	
	    	driver = new InternetExplorerDriver();
	    } else if (browser.equals("opera")) {
	    	
	    	driver = new OperaDriver();
	    	
	    } else if (browser.equals("safari")) {
	    	driver = new SafariDriver();
	    
	    
	  }
	 
	    	baseUrl = "http://gnomiki.test-lemon.com/";
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 


				
	    		  @AfterTest
	    		  public void tearDown() throws Exception {
	    		    driver.quit();
	    		    String verificationErrorString = verificationErrors.toString();
	    		    if (!"".equals(verificationErrorString)) {
	    		      fail(verificationErrorString);
	    		    }
	    		  }
	    		  protected boolean isElementPresent(By by) {
	    			    try {
	    			      driver.findElement(by);
	    			      return true;
	    			    } catch (NoSuchElementException e) {
	    			      return false;
	    			    }
	    			  }

}

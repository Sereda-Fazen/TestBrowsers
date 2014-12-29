package com.browser.tests;


import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;


	
public class TestBrowsers extends BaseTest {

@Test
  public void TestBrowser() {
	  	driver.get(baseUrl + "login");
	    driver.findElement(By.id("input-email")).sendKeys("fazen7@mail.ru");
	    driver.findElement(By.id("input-password")).sendKeys("12345");
	    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	    assertTrue(isElementPresent(By.linkText("Середа Александр Игоревич")));
  }
}
 


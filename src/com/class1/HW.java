package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
TC 1: HRMS Application Login: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username and password
Click on login button
Then verify Syntax Logo is displayed
Close the browser

TC 2: HRMS Application Negative Login: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.

 * 
 */
public class HW extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void LoginCredentials() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean logo=driver.findElement(By.xpath("//img[@width='283']")).isDisplayed();
		
		if(logo) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Failed");
	}
	
//	@Test
//	public void logoIsDisplay() {
//	boolean logo=driver.findElement(By.xpath("//img[@width='283']")).isDisplayed();
//	
//	if(logo) {
//		System.out.println("Test Pass");
//	}else {
//		System.out.println("Test Failed");
//	}
//	}

}}

package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;
/* Open Application
 * Verify logo is displayed
 * Enter valid credentials
 * Verify user successfully logged in
 */
public class SoftAssertionsDemo extends CommonMethods {

	
	@BeforeMethod
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}
	
	
	@Test(groups="smoke")
	public void LogoAndLogin() {
		boolean logo=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logo=false;
		//HARD ASSERT will fail and execution here will stop. it will not execute the log ing code
		//Assert.assertTrue(logo, " Syntax Logo is Not display");
	
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(logo, " Syntax Logo is Not display");
		
			driver.findElement(By.id("txtUsername")).sendKeys("admin");
			driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
			driver.findElement(By.id("btnLogin")).click();
		
			boolean welcome=driver.findElement(By.id("welcome")).isDisplayed();
			//Hard Assertion
//			Assert.assertTrue(welcome, "Welcome not display");
			
			//Soft Assertion
			soft.assertTrue(welcome, "Welcome not display");
			//Collects all Failures and throws message at the end of program 
			soft.assertAll();
}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
}

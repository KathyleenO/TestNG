package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionTask extends CommonMethods{



	@BeforeMethod(alwaysRun=true)
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test()
	public void LoginCredentials() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean logo=driver.findElement(By.xpath("//img[@width='283']")).isDisplayed();
	
		Assert.assertTrue(logo," Test Pass ");
		
//		if(logo) {
//			System.out.println("Test Pass");
//		}else {
//			System.out.println("test failed");
//	}
	
	}
	
	@Test(priority=1 )
	public void negativeLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		//boolean spanMsg=driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed();
	
		String expectederror="Password cannot be empty";
		
		Assert.assertEquals(error, expectederror, "PASS TEST");
		
//		if(error.isDisplayed()) {
//			System.out.println("Test Pass");
//			if(error.getText().equals(expectederror)) {
//				System.out.println("error is correct");
//			}else {
//				System.out.println("error not correct");
//			}
//			
//		}else {
//			System.out.println("Test Failed");
//		}
		
	
	}
}



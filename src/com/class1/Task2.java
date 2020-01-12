package com.class1;
/*TC 2: HRMS Application Negative Login: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.

 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task2 extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void negativeLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		//boolean spanMsg=driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed();
	
		String expectederror="Password cannot be empty";
		if(error.isDisplayed()) {
			System.out.println("Test Pass");
			if(error.getText().equals(expectederror)) {
				System.out.println("error is correct");
			}else {
				System.out.println("error not correct");
			}
			
		}else {
			System.out.println("Test Failed");
		}
		
	
	}
	
	
	
	
	
}

package com.class1;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TitleLogoAndLoginVerification extends CommonMethods {

	
	
	@BeforeMethod
	public void openAndNavigate() {
		SetUp("chrome", Constants.HRMS_URL);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fails");
		}
	}
	@Test
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		if (isDisplayed) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
	}
	
	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
	

	
	
	
}

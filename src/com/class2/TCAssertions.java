package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;
/*Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Verify Employee has been added successfully
Close the browse
 * 
 */
public class TCAssertions extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}

//	@AfterMethod
//	public void closeBrowser() {
//		driver.quit();
//	}
	
	@Test
	public void task() {
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.id("btnLogin")).click();
	
	driver.findElement(By.linkText("PIM")).click();
	
	WebDriverWait wait4=new WebDriverWait(driver,30);
	wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
	
	driver.findElement(By.linkText("Add Employee")).click();
	}
	
}

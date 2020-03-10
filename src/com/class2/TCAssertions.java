package com.class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

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

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void task() {
	//log in and Open browser
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.id("btnLogin")).click();
	//click on PIM
	driver.findElement(By.linkText("PIM")).click();
	//Wait to load 
	WebDriverWait wait4=new WebDriverWait(driver,30);
	wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
	//Click on button ADD EMPLOYEE
	driver.findElement(By.linkText("Add Employee")).click();
	
	//CHECK IF NAME, PHOTGRAPH, ID IS THERE THE LABEL
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	boolean FN=driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
	SoftAssert verify=new SoftAssert();
	verify.assertTrue(FN, "NOt Displayed");
	 boolean id=driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
	 verify.assertTrue(id, "Not there");
	 boolean pic=driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
	 verify.assertTrue(pic, "Not there");
	 
	 //SEND FIRST NAME AND LAST NAME
	 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Jack");
	 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Lopez");
	 
	 //CLICK SAVE BUTTON
	 driver.findElement(By.id("btnSave")).click();
	 
	 //ADD BUTTON
	 driver.findElement(By.cssSelector("input#btnAddAttachment")).click();
	 
	}
	
}

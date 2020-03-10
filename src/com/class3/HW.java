package com.class3;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*TC 1: HRMS Add Employee: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Provide Employee First and Last Name
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.

 * 
 */
public class HW extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		SetUp("chrome", Constants.HRMS_URL);
	}
	

	
//	@Test(dataProvider = "employees", groups="regression")
//	public void Login(String name, String lastname, String user, String password, String pass)
//			throws InterruptedException {
//		
//		
//
//		// login into HRMS
//		driver.findElement(By.id("txtUsername")).sendKeys("admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
//		driver.findElement(By.id("btnLogin")).click();
//		// navigate to add employee
//		driver.findElement(By.linkText("PIM")).click();
//	
//		TakesScreenshot ts1=(TakesScreenshot)driver;
//		File picture1=ts1.getScreenshotAs(OutputType.FILE);
//		try {
//		FileUtils.copyFile(picture1, new File("taskScreenshots/HRMS/pimpage.png"));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
//		driver.findElement(By.linkText("Add Employee")).click();
//
//
//		// ADDING EMPLOYEE
//		WebDriverWait wait4 = new WebDriverWait(driver, 30);
//		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='firstName']")));
//		// FIRST NAME AND LASTNAME
//		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(name);
//		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
//		// CLICK ON CREATE LOGIN DETAILS
//
//		driver.findElement(By.id("chkLogin")).click();
//        //ADDING USERNAME AND PASSWORD CREDENTIALS
//	
//		// USERNAME
//		driver.findElement(By.id("user_name")).sendKeys(user);
//	
//		driver.findElement(By.id("user_password")).sendKeys(password);
//
//		driver.findElement(By.id("re_password")).sendKeys(pass);
//        //CLICK ON SAVE BUTTON
//		
//		JavascriptExecutor savebutton= (JavascriptExecutor)driver;
//		
//		WebElement b=driver.findElement(By.xpath("//input[@id='btnSave']"));
//		savebutton.executeScript("arguments[0].click();", b);
//	
////		WebDriverWait wait6= new WebDriverWait(driver,30);
////		wait6.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Personal Details")));
////		driver.findElement(By.linkText("Personal Details")).click();
//		
//		SoftAssert employeAdd= new SoftAssert();
//		boolean empDetails = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
//		employeAdd.assertTrue(empDetails, " Employee Details not displayed");
//		
//		//Taking screenshots
//		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File picture=ts.getScreenshotAs(OutputType.FILE);
//		try {
//		FileUtils.copyFile(picture, new File("taskScreenshots/HRMS/"+name+ lastname+".png"));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		employeAdd.assertAll();
//		
//	}
		
	@Test(groups="regression")
	public void Login()throws InterruptedException {
		
		

		// login into HRMS
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		// navigate to add employee
		driver.findElement(By.linkText("PIM")).click();
	
		TakesScreenshot ts1=(TakesScreenshot)driver;
		File picture1=ts1.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(picture1, new File("taskScreenshots/HRMS/pimpage.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
		driver.findElement(By.linkText("Add Employee")).click();


		// ADDING EMPLOYEE
		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='firstName']")));
		// FIRST NAME AND LASTNAME
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("weqas");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("haq");
		// CLICK ON CREATE LOGIN DETAILS

		driver.findElement(By.id("chkLogin")).click();
        //ADDING USERNAME AND PASSWORD CREDENTIALS
	
		// USERNAME
		driver.findElement(By.id("user_name")).sendKeys("weqashaq");
	
		driver.findElement(By.id("user_password")).sendKeys("122122");

		driver.findElement(By.id("re_password")).sendKeys("pireeeee11221");
        //CLICK ON SAVE BUTTON
		
		JavascriptExecutor savebutton= (JavascriptExecutor)driver;
		
		WebElement b=driver.findElement(By.xpath("//input[@id='btnSave']"));
		savebutton.executeScript("arguments[0].click();", b);
	
//		WebDriverWait wait6= new WebDriverWait(driver,30);
//		wait6.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Personal Details")));
//		driver.findElement(By.linkText("Personal Details")).click();
		
		SoftAssert employeAdd= new SoftAssert();
		boolean empDetails = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
		employeAdd.assertTrue(empDetails, " Employee Details not displayed");
		
		//Taking screenshots
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File picture=ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(picture, new File("taskScreenshots/HRMS/"+"weqas"+ "haq1"+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		employeAdd.assertAll();
		
	}
		





//USE DATAPROVIDER FOR INPUTING DATA TO ABOVE PARAMETERS
	@DataProvider
	public Object[][] employees() {
		Object[][] data = { { "Josh", "Smith", "SJosh12", "SyntaxHMS2020!", "SyntaxHMS2020!" },
				{ "Karla", "Ayala", "KAyala23", "SyntaxHMS2020!", "SyntaxHMS2020!" },
				{ "Katie", "Lopez", "KateLopez1", "SyntaxHMS2020!", "SyntaxHMS2020!" },
				{ "Kathy", "Smith", "Kat2345", "SyntaxHMS2020!", "SyntaxHMS2020!" },
				{ "Kylie", "Peter", "Kylie2020", "SyntaxHMS2020!", "SyntaxHMS2020!" }, };
		return data;
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}

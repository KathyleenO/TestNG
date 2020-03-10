package com.class3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

public class AlwaysRun {

	@BeforeTest(alwaysRun=true)
	public void beforeTest() {
		System.out.println("I am before Test");
	}
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		System.out.println("I am before suite ");
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeClass() {
		System.out.println("I am before class");
	}
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		System.out.println("I am after method");
	}
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		System.out.println("I am after class");
	}
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		System.out.println("I am after Test");
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		System.out.println("I am before suite ");
	}
	
	@Test
	public void testMethod() {
		System.out.println("I am test");
	}
	
	
}

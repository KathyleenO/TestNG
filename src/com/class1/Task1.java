package com.class1;

import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/*Task 1: Executing different test based TestNG annotations
 * Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation

Observe the results!
 */


public class Task1 {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class I am at HOME");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class CHURCH");
	}
	
	@BeforeMethod
	public void beforeMethods() {
		System.out.println("Before Method I SLEEP");
	}
	
	@AfterMethod
	public void afterMethods() {
		System.out.println("After Method STUDY");
	}
	
	@Test
	public void test() {
		System.out.println("SATURDAY");
	}
	@Test
	public void test2() {
		System.out.println("SUNDAY");
	}
	
	
}

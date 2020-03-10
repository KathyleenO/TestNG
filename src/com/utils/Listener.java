package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test started"+result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed" +result.getName());
		CommonMethods.takesScreenshot("/passed"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed" +result.getName());
		CommonMethods.takesScreenshot("/Failed"+result.getName());
	}
	
	
	
}

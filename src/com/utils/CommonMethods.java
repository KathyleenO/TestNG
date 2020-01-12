package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Command o==> for Mac to see all methods 
public class CommonMethods {

	public static WebDriver driver;

	/**
	 * 
	 * @param browser insert in String any browser "Chrome or "Firefox"
	 * @param url     put any url you want to be open
	 */

	public static void SetUp(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.err.println("Browser Not Supported");
		}

		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	/**
	 * This method will accept the alert
	 * 
	 * @throws will throw an NoAlertPresentException if alert is NOt present
	 * 
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}

	}

	/**
	 * This method will dismiss the alert
	 * 
	 * @throws will throw an NoAlertPresentException if alert is NOt present
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("");
		}
	}

	/**
	 * This method will get a text from the alert
	 * 
	 * @return text of the alert
	 * @throws will throw an NoAlertPresentException if alert is NOt present
	 */

	public static String getAlertText() {
		String text = null;
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();

		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
		return text;
	}

	/**
	 * This method will switch to frame with Name or ID
	 * 
	 * @param nameORId
	 */
	public static void switchToFrame(String nameORId) {

		try {
			driver.switchTo().frame(nameORId);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will switch to frame with WebElement
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will switch to frame by Index
	 * 
	 * @param index
	 */
	public static void switchToFrame(Integer index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}

	}

	/**
	 * This method will click on the element using JavaScriptExecutor
	 * 
	 * @param element
	 */
	public static void jsCLick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	/**
	 * This method will scroll until specified element
	 * 
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll page up
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

}

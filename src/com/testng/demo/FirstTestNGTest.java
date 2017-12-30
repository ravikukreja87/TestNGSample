package com.testng.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DefectUtils;
import utils.ExceptionUtils;
import utils.WebDriverUtils;

public class FirstTestNGTest {
	private static final String ACTUAL_RESULT = "Actual Result = ";

	@Test(priority = 1)
	public void login() {
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		WebElement userNameTxtBox = driver.findElement(By.name("txtuname"));
		userNameTxtBox.clear();
		userNameTxtBox.sendKeys("techcanvassacademy@techcanvass.co.in");
		driver.findElement(By.id("txtpwd")).sendKeys("abhishek1234");
		driver.findElement(By.id("loginbtn")).click();

		String expectedResult = "Welcome Techcanvass Academy";
		String actualResultPartOne = driver.findElement(By.id("ctl00_Label23")).getText();
		String actualResultPartTwo = driver.findElement(By.id("ctl00_lblloginuser")).getText();

		if (actualResultPartTwo.isEmpty()) {
			Assert.fail("Failing as name was null on website");
		}
		String actualResult = actualResultPartOne + " " + actualResultPartTwo;
		System.out.println("Actual Result = " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Login Unsuccessful!!!!");
		boolean condition = expectedResult.contains(actualResultPartTwo);
		Assert.assertTrue(condition);
	}

	@Test(priority = 1)
	public void loginFailed() {
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		WebElement userNameTxtBox = driver.findElement(By.name("txtuname"));
		userNameTxtBox.clear();
		userNameTxtBox.sendKeys("techcanvassacademy@techcanvass.co.in");
		driver.findElement(By.id("txtpwd")).sendKeys("abhisk1234");
		driver.findElement(By.id("loginbtn")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String expectedResult = "Welcome Techcanvass Academy";
		String actualResultPartOne = null;
		String actualResultPartTwo = null;
		String actualResult = null;
		try {
			actualResultPartOne = driver.findElement(By.id("ctl00_Label23")).getText();
			actualResultPartTwo = driver.findElement(By.id("ctl00_lblloginuser")).getText();
			actualResult = actualResultPartOne + actualResultPartTwo;
			System.out.println(ACTUAL_RESULT + actualResult);
		} catch (NoSuchElementException nsee) {
			ExceptionUtils.useUserFriendlyMessages(nsee);
		} catch (Exception e) {
			ExceptionUtils.useUserFriendlyMessages(e);
		}

		try {
			Assert.assertEquals(actualResult, expectedResult, "Login Unsuccessful!!!!");
		} catch (AssertionError ae) {
			ExceptionUtils.useUserFriendlyMessages(ae);
			DefectUtils.createABug(ae.getCause(), ae.getMessage(), ae.getStackTrace(), ae.getClass());
			WebDriverUtils.giveMeAScreenShot(driver, Test.class.getName().toString());
			Assert.fail(ae.getMessage());
		}
	}
}
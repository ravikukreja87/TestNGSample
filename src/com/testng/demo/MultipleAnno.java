package com.testng.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MultipleAnno {
	WebDriver driver;

	@Test
	public void login1() {
		System.out.println("Starting TEST 1");
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		WebElement userNameTxtBox = driver.findElement(By.name("txtuname"));
		userNameTxtBox.clear();
		userNameTxtBox.sendKeys("techcanvassacademy@techcanvass.co.in");
		driver.findElement(By.id("txtpwd")).sendKeys("abhishek1234");
		driver.findElement(By.id("loginbtn")).click();

	}

	@Test
	public void login2() {
		System.out.println("Starting TEST 2");
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		WebElement userNameTxtBox = driver.findElement(By.name("txtuname"));
		userNameTxtBox.clear();
		userNameTxtBox.sendKeys("techcanvassacademy@techcanvass.co.in");
		driver.findElement(By.id("txtpwd")).sendKeys("abhishek1234");
		driver.findElement(By.id("loginbtn")).click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod2() {
		System.out.println("Inside After Method TWO");
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Inside After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite");
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside After Suite");
	}

}

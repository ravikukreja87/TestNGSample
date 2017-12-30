/**
 * To test login success for three user ids and passwords
 */

package com.testng.demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DDDemo {
	WebDriver driver;

	@Test(dataProvider = "testData")
	public void testLogin(String userName, String password, String type) {

		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		WebElement userNameTxtBox = driver.findElement(By.name("txtuname"));
		userNameTxtBox.clear();
		userNameTxtBox.sendKeys(userName);
		driver.findElement(By.id("txtpwd")).sendKeys(password);
		WebElement typeDropDown = driver.findElement(By.id("ddlloginuser"));
		Select s = new Select(typeDropDown);
		if (type.isEmpty())
			type = "Student";
		s.selectByVisibleText(type);
		driver.findElement(By.id("loginbtn")).click();
		WebElement welcomeLabel = driver.findElement(By.id("ctl00_Label23"));
		String actualResult = welcomeLabel.getText();
		String expectedResult = "Welcome";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] testData() {
		return new Object[][] { new Object[] { "techcanvassacademy@techcanvass.co.in", "abhishek1234", "Employee" },
				new Object[] { "techcanvassuser@techcanvass.co.in", "user1234", "Student" },
				new Object[] { "techcanvassuser@techcanvass.co.in", "user1234", "" }, 
				new Object[] { "techcanvassuser@techcanvass.co.in", "user123", "" }, 
						
		};
	}
}

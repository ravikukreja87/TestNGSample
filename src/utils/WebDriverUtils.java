package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

	public static void giveMeAScreenShot(WebDriver driver, String fileName) {
		File failingImage;
		failingImage = new File("screenshots/" + fileName);
		failingImage.mkdir();

		File sourceImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceImage, failingImage);
		} catch (IOException e) {
			ExceptionUtils.useUserFriendlyMessages(e);
		}
		if (failingImage.exists())
			System.out.println("Captured Successfully");
		else
			System.out.println("Failed to Capture");
	}

}

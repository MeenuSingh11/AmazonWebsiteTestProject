package com.amazon.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShotUtil {

	public static void captureScreenShot(WebDriver driver, String screenShotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(source, new File("./Screenshot/" + screenShotName + ".png"));

		} catch (IOException e) {

			System.out.println("Exception while taking the screenshot");
		}

		System.out.println("screenshot taken");

	}

}

package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.util.ScreenShotUtil;

public class HomePageFilterTest extends TestBase {
	HomePage homePage;

	public HomePageFilterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}

	@Test
	public void verifyHomePageSweetsFilterTest() throws InterruptedException {
		String title = homePage.validateHomePageSearch();
		Assert.assertEquals(title, "Amazon Sign In");
		ScreenShotUtil.captureScreenShot(driver, "Amazon Sign In Page");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

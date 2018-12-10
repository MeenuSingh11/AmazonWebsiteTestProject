package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;
import com.amazon.util.ScreenShotUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement enterText;

	@FindBy(xpath = "//input[@type = 'submit' and @class= 'nav-input']")
	WebElement searchButton;

	@FindBy(id = "sort")
	WebElement sortPrice;

	@FindBy(id = "addToCart-B01D6EGL40")
	WebElement addToCartSnickers;

	@FindBy(id = "addToCart-B013P4XWIE")
	WebElement addToCartTwix;

	@FindBy(id = "addToCart-B017IRVVIW")
	WebElement addToCartSkittles;

	@FindBy(id = "hlb-ptc-btn-native")
	WebElement proceedToCheckout;

	// Initialising the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageSearch() throws InterruptedException {
		String[] products = { "Snickers", "Twix", "Skittles" };
		for (int i = 0; i < products.length; i++) {
			enterText.sendKeys(products[i]);
			searchButton.click();
			Select select = new Select(sortPrice);
			select.selectByVisibleText("Price: Low to High");
			Thread.sleep(2000);
			if (products[i] == "Snickers") {
				addToCartSnickers.click();
				ScreenShotUtil.captureScreenShot(driver, "Snicker search added to the cart");
			} else if (products[i] == "Twix") {
				addToCartTwix.click();
				ScreenShotUtil.captureScreenShot(driver, "Twix search added to the cart");
			} else if (products[i] == "Skittles") {
				addToCartSkittles.click();
				ScreenShotUtil.captureScreenShot(driver, "Skittles search added to the cart");
			}
			Thread.sleep(2000);
		}
		proceedToCheckout.click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		return title;
	}
}

package com.manahealth.sv.ui.tests.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

	private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

	private DriverFactory() {
	}

	public static WebDriver getWebDriver() {
		return getWebDriver(DriverType.CHROME);
	}

	public static WebDriver getWebDriver(DriverType driverType) {
		log.info(String.format("Creating WebDriver instance of type: {}", driverType));

		switch (driverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
			return new ChromeDriver();
		case FIREFOX:
			break;
		default:
			break;
		}
		return null;
	}

	public static void quitWebDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}
}

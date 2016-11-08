package com.manahealth.sv.ui.tests.framework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

	private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private DriverFactory() {
	}

	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(DriverType driverType) {
		driver.set(getWebDriverInsatance(driverType));
	}

	public static void quitWebDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
		driver = null;
		log.info("Driver instanse is destroyed");
	}

	private static WebDriver getWebDriverInsatance(DriverType driverType) {
		log.info(String.format("Creating WebDriver instance of type: %s", driverType));
		WebDriver driver = createWebDriverInstance(driverType);

		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		return driver;
	}
	
	private static WebDriver createWebDriverInstance(DriverType driverType) {
		switch (driverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			return new ChromeDriver();
		case FIREFOX:
			break;
		default:
			break;
		}
		return null;
	}
}

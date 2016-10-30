package com.manahealth.sv.ui.tests.testcases.tests;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.driver.DriverType;

public class BaseTest {
	protected WebDriver driver = null;

	public BaseTest(){
		driver = DriverFactory.getWebDriver(DriverType.CHROME);
	}
}

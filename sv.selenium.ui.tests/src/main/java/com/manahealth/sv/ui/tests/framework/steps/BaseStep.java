package com.manahealth.sv.ui.tests.framework.steps;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.framework.driver.AppContext;

public class BaseStep {

	protected WebDriver driver = null;
	protected AppContext context = AppContext.getInstance();

	public BaseStep(WebDriver driver) {
		this.driver = driver;
	}

}

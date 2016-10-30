package com.manahealth.sv.ui.tests.framework.steps;

import org.openqa.selenium.WebDriver;

public class BaseStep {

	protected WebDriver driver = null;

	public BaseStep(WebDriver driver) {
		this.driver = driver;
	}

}

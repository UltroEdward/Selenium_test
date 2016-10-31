package com.manahealth.sv.ui.tests.framework.pages.app;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.framework.pages.BasePage;

public class HomePage extends BasePage{

	private static final String LOAD_INDICATOR = "//a[contains(@class, 'logo')]";
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
	}

}
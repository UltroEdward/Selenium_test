package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.application.pages.HomePage;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class HomeStep extends BaseStep{

	public HomePage loginPage = PageFactory.initElements(driver, HomePage.class);
	
	public HomeStep(WebDriver driver) {
		super(driver);
	}
	
}

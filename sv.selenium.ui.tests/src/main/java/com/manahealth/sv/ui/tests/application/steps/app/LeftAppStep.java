package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.application.helpers.AllApps;
import com.manahealth.sv.ui.tests.application.pages.HomePage;
import com.manahealth.sv.ui.tests.application.pages.left.navbar.AbstarctLeftAppMenuPage;
import com.manahealth.sv.ui.tests.application.pages.left.navbar.ReqLeftAppMenuPage;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class LeftAppStep extends BaseStep {

	public HomePage loginPage = PageFactory.initElements(driver, HomePage.class);

	public LeftAppStep(WebDriver driver) {
		super(driver);
	}

	public void openApp(AllApps app) {
		switch (app) {
		case SEARCH:
			new ReqLeftAppMenuPage(DriverFactory.getDriver()).goToSearchBtn.click();
			break;
		case REQUESTS:
			new AbstarctLeftAppMenuPage(DriverFactory.getDriver()).goToRequestsBtn.click();
			break;
		case HOME:
			new AbstarctLeftAppMenuPage(DriverFactory.getDriver()).goToRequestsBtn.click();
			break;
		}
	}
	
}

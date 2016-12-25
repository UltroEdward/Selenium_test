package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.application.helpers.Applications;
import com.manahealth.sv.ui.tests.application.pages.left.navbar.LeftMenuApps;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class LeftAppStep extends BaseStep {

	private LeftMenuApps leftMenuPage = new LeftMenuApps(DriverFactory.getDriver());

	public LeftAppStep(WebDriver driver) {
		super(driver);
	}

	public void openApp(Applications app) {
		switch (app) {
		case SEARCH:
			leftMenuPage.goToSearchBtn.click();
			break;
		case REQUESTS:
			leftMenuPage.goToRequestsBtn.click();
			break;
		case HOME:
			leftMenuPage.goToRequestsBtn.click();
			break;
		}
	}

}

package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.application.helpers.Applications;
import com.manahealth.sv.ui.tests.application.pages.left.navbar.AbstarctLeftAppMenuPage;
import com.manahealth.sv.ui.tests.application.pages.left.navbar.ReqLeftAppMenuPage;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class LeftAppStep extends BaseStep {

	public LeftAppStep(WebDriver driver) {
		super(driver);
	}

	public void openApp(Applications app) {
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

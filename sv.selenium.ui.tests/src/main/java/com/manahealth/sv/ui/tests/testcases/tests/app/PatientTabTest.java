package com.manahealth.sv.ui.tests.testcases.tests.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.application.helpers.RequestStatus;
import com.manahealth.sv.ui.tests.application.steps.app.LoginStep;
import com.manahealth.sv.ui.tests.application.steps.app.PatientTabStep;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.testcases.tests.BaseTest;

public class PatientTabTest extends BaseTest {

	@DataProvider
	public Object[][] tabsToCheck() {
		return new RequestStatus[][] { {RequestStatus.APPROVED}, {RequestStatus.DENIED}, {RequestStatus.PENDING}};
	}

	@Test(description = "CCheck patients table tabs for requester", dataProvider = "tabsToCheck")
	public void checkHeaderReqApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsReq();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.selectTab(status);
		patentTab.checkReqTableHeader(status);
	}
	
	@Test(description = "Check patients table tabs for provider", dataProvider = "tabsToCheck")
	public void checkHeaderProvApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsProv();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.selectTab(status);
		patentTab.checkProvTableHeader(status);
	}
}

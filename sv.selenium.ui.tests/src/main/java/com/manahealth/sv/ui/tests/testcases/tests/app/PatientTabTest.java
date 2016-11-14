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
		return new RequestStatus[][] { { RequestStatus.APPROVED }, { RequestStatus.DENIED }, { RequestStatus.PENDING } };
	}

	@Test(description = "Check patients table tabs for requester", dataProvider = "tabsToCheck")
	public void checkHeaderReqApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsReq();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);
		patentTab.checkReqTableHeader(status);
	}

	@Test(description = "Check patients table tabs for provider", dataProvider = "tabsToCheck")
	public void checkHeaderProvApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsProv();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);
		patentTab.checkProvTableHeader(status);
	}

	@Test(description = "Check patients data in table for provider", dataProvider = "tabsToCheck")
	public void checkTableDataForProviderApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsProv();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);

		int patientsTocheck = patentTab.getPatientsCount();
		while (patientsTocheck > 0) {
			patentTab.isProvPatientTableDataValid(patientsTocheck, status);
			patientsTocheck--;
		}
	}
	
	public void checkTableDataForRequesterApp(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsReq();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);

		int patientsTocheck = patentTab.getPatientsCount();
		while (patientsTocheck > 0) {
			patentTab.isReqPatientTableDataValid(patientsTocheck, status);
			patientsTocheck--;
		}
	}
	
	@Test(description = "Check pagination if possible for requester's tabs, by oipening last element and checking table", dataProvider = "tabsToCheck")
	public void checkPaginationReq(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsReq();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);
		if (patentTab.getPatientCountFromPadding()>10){
			patentTab.moveByPaddingNext();
			int patientsTocheck = patentTab.getPatientsCount();
			while (patientsTocheck > 0) {
				patentTab.isReqPatientTableDataValid(patientsTocheck, status);
				patientsTocheck--;
			}
		}
	}
	
	@Test(description = "Check pagination if possible for provider's tabs, by oip[ening last element and checking table", dataProvider = "tabsToCheck")
	public void checkPaginationProv(RequestStatus status) {
		new LoginStep(DriverFactory.getDriver()).loginAsProv();
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		patentTab.openTab(status);
		if (patentTab.getPatientCountFromPadding()>10){
			patentTab.moveByPaddingNext();
			int patientsTocheck = patentTab.getPatientsCount();
			while (patientsTocheck > 0) {
				patentTab.isReqPatientTableDataValid(patientsTocheck, status);
				patientsTocheck--;
			}
		}
	}
}

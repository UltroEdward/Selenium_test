package com.manahealth.sv.ui.tests.testcases.tests.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.application.helpers.RequestStatus;
import com.manahealth.sv.ui.tests.application.steps.app.LoginStep;
import com.manahealth.sv.ui.tests.application.steps.app.PatientTabStep;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.testcases.tests.BaseTest;

public class PatientTabTest extends BaseTest {

	public static final RequestStatus[] statuses = { RequestStatus.APPROVED, RequestStatus.DENIED, RequestStatus.PENDING };

	@DataProvider
	public String[][] credentials() {
		return new String[][] { { appContext.getUsernameReq(), appContext.getPasswordReq() }, { appContext.getUsernameProv(), appContext.getPasswordProv() } };
	}

	@Test(description = "Check that requester see patients basic table header", dataProvider = "credentials")
	public void checkHeader(String userName, String password) {
		new LoginStep(DriverFactory.getDriver()).login(userName, password);

		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		for (RequestStatus tab : statuses) {
			patentTab.openTab(tab);
			new PatientTabStep(DriverFactory.getDriver()).checkBaseHeader(tab);
		}

	}

	@Test(description = "Check basic patients data in table for requester", dataProvider = "credentials")
	public void checkTableData(String userName, String password) {
		new LoginStep(DriverFactory.getDriver()).login(userName, password);

		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		for (RequestStatus tab : statuses) {
			patentTab.openTab(tab);
			loopAncCheckVisiblePatients();
		}

	}

	@Test(description = "Check pagination if possible for requester's tabs, by opening last element and checking table", dataProvider = "credentials")
	public void checkPaginationReq(String userName, String password) {
		new LoginStep(DriverFactory.getDriver()).login(userName, password);

		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		for (RequestStatus tab : statuses) {
			patentTab.openTab(tab);
			if (patentTab.getVisibleCountOfPatinets() == 10 && patentTab.getPatientCountFromPadding() > 10) {
				patentTab.moveByPaddingNext();
				loopAncCheckVisiblePatients();
			}
		}

	}

	private void loopAncCheckVisiblePatients() {
		PatientTabStep patentTab = new PatientTabStep(DriverFactory.getDriver());
		int patientsTocheck = patentTab.getVisibleCountOfPatinets();
		while (patientsTocheck > 0) {
			patentTab.checkBasePatientRecord(patientsTocheck);
			patientsTocheck--;
		}
	}

}

package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.application.helpers.RequestStatus;
import com.manahealth.sv.ui.tests.application.pages.patients.AbstractPatientsTablePage;
import com.manahealth.sv.ui.tests.application.pages.patients.PatientTabProvider;
import com.manahealth.sv.ui.tests.application.pages.patients.PatientsTableRequester;
import com.manahealth.sv.ui.tests.framework.assertions.IAssert;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class PatientTabStep extends BaseStep {

	public PatientsTableRequester page = new PatientsTableRequester(driver);

	public PatientTabStep(WebDriver driver) {
		super(driver);
	}

	public void selectTab(RequestStatus status) {
		switch (status) {
		case APPROVED:
			page.approvedTabBtn.click();
			break;
		case DENIED:
			page.deniedTabBtn.click();
			break;
		case PENDING:
			page.pendingTabBtn.click();
		default:
			break;

		}
	}

	public void checkReqTableHeader(RequestStatus status) {
		PatientsTableRequester baseTablePage = new PatientsTableRequester(driver);
		IAssert.assertEquals(baseTablePage.providerLbl.getText(), "Provider");
		IAssert.assertEquals(baseTablePage.submitedLbl.getText(), "Submitted");
		checkBaseHeader(baseTablePage);

		switch (status) {
		case APPROVED:
			IAssert.assertEquals(baseTablePage.approvedLbl.getText(), "Approved");
			break;
		case DENIED:
			IAssert.assertEquals(baseTablePage.deniedLbl.getText(), "Denied");
			break;
		default:
			break;
		}
	}

	public void checkProvTableHeader(RequestStatus status) {
		PatientTabProvider baseTablePage = new PatientTabProvider(driver);
		checkBaseHeader(new PatientsTableRequester(driver));
		IAssert.assertEquals(baseTablePage.requesterLbl.getText(), "Requester");
		IAssert.assertEquals(baseTablePage.requestedLbl.getText(), "Requested");

		switch (status) {
		case APPROVED:
			IAssert.assertEquals(baseTablePage.approvedLbl.getText(), "Approved");
			break;
		case DENIED:
			IAssert.assertEquals(baseTablePage.deniedLbl.getText(), "Denied");
			break;
		default:
			break;
		}
	}

	private void checkBaseHeader(AbstractPatientsTablePage baseTablePage) {
		IAssert.assertEquals(baseTablePage.nameLbl.getText(), "Patient Name");
		IAssert.assertEquals(baseTablePage.dobLbl.getText(), "DOB");
		IAssert.assertEquals(baseTablePage.sexLbl.getText(), "Sex");
		IAssert.assertEquals(baseTablePage.ssnLbl.getText(), "SSN");
		IAssert.assertEquals(baseTablePage.addressLbl.getText(), "Address");
		IAssert.assertEquals(baseTablePage.cityLbl.getText(), "City");
		IAssert.assertEquals(baseTablePage.stateLbl.getText(), "State");
		IAssert.assertEquals(baseTablePage.zipLbl.getText(), "Zip");
	}

}

package com.manahealth.sv.ui.tests.application.steps.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.application.dto.PatientDto;
import com.manahealth.sv.ui.tests.application.helpers.RequestStatus;
import com.manahealth.sv.ui.tests.application.pages.patients.BasePatientsTablePage.TableItemsPosition;
import com.manahealth.sv.ui.tests.application.pages.patients.PatientsTableRequester;
import com.manahealth.sv.ui.tests.framework.assertions.IAssert;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;
import com.manahealth.sv.ui.tests.framework.utils.AssertUtils;

public class PatientTabStep extends BaseStep {

	public PatientsTableRequester patientsPage = new PatientsTableRequester(driver);
	public static final String EMPTY_VALUE = "---";

	public PatientTabStep(WebDriver driver) {
		super(driver);
	}

	public void openTab(RequestStatus status) {
		switch (status) {
		case APPROVED:
			patientsPage.approvedTabBtn.click();
			break;
		case DENIED:
			patientsPage.deniedTabBtn.click();
			break;
		case PENDING:
			patientsPage.pendingTabBtn.click();
		default:
			break;
		}
	}

	public void checkBaseHeader(RequestStatus status) {

		PatientsTableRequester baseTablePage = new PatientsTableRequester(driver);

		IAssert.assertEquals(baseTablePage.firstNameLbl.getText(), "First Name");
		IAssert.assertEquals(baseTablePage.lastNameLbl.getText(), "Last Name");
		IAssert.assertEquals(baseTablePage.dobLbl.getText(), "DOB");
		IAssert.assertEquals(baseTablePage.sexLbl.getText(), "Sex");
		IAssert.assertEquals(baseTablePage.ssnLbl.getText(), "SSN");
		IAssert.assertEquals(baseTablePage.addressLbl.getText(), "Address");
		IAssert.assertEquals(baseTablePage.cityLbl.getText(), "City");
		IAssert.assertEquals(baseTablePage.stateLbl.getText(), "State");
		IAssert.assertEquals(baseTablePage.zipLbl.getText(), "Zip");
	}

	public void checkBasePatientRecord(int patientNumber) {
		PatientDto patient = getBasicPatientData(patientNumber);
		AssertUtils.regExpMatches(patient.getDob(), "[0-9]{2}-[0-9]{2}-[0-9]{4}", EMPTY_VALUE);
		AssertUtils.regExpMatches(patient.getSex(), "[M|F]", EMPTY_VALUE);
	}

	public int getVisibleCountOfPatinets() {
		return patientsPage.abstarctPatientLbl.size();
	}

	public int getPatientCountFromPadding() {
		String label = patientsPage.paginationLbl.getText();
		Pattern p = Pattern.compile("\\([0-9]+");
		Matcher m = p.matcher(label);
		if (m.find()) {
			String find = m.group(0);
			return Integer.parseInt(find.substring(1));
		}
		return -1;
	}

	public void moveByPaddingNext() {
		patientsPage.paginationNextBtn.click();
	}

	public PatientDto getBasicPatientData(int patientNumber) {
		ILabel absPatientRow = patientsPage.abstarctPatientLbl.get(patientNumber-1);
		PatientDto patient = new PatientDto();

		patient.setfName(getCellValue(absPatientRow, TableItemsPosition.F_NAME));
		patient.setlName(getCellValue(absPatientRow, TableItemsPosition.L_NAME));
		patient.setDob(getCellValue(absPatientRow, TableItemsPosition.DOB));
		patient.setSex(getCellValue(absPatientRow, TableItemsPosition.SEX));
		patient.setSsn(getCellValue(absPatientRow, TableItemsPosition.SSN));
		patient.setAddress(getCellValue(absPatientRow, TableItemsPosition.ADDRESS));
		patient.setCity(getCellValue(absPatientRow, TableItemsPosition.CITY));
		patient.setState(getCellValue(absPatientRow, TableItemsPosition.STATE));
		patient.setZip(getCellValue(absPatientRow, TableItemsPosition.ZIP));

		return patient;
	}

	private String getCellValue(ILabel patientRowItem, TableItemsPosition headerName) {
		return patientRowItem.getWrappedElement().findElements(By.xpath(".//td")).get(headerName.getPosition()).getText();
	}

}

package com.manahealth.sv.ui.tests.application.steps.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.manahealth.sv.ui.tests.application.dto.PatientDto;
import com.manahealth.sv.ui.tests.application.dto.PatientProviderDto;
import com.manahealth.sv.ui.tests.application.dto.PatientRequesterDto;
import com.manahealth.sv.ui.tests.application.helpers.RequestStatus;
import com.manahealth.sv.ui.tests.application.pages.patients.AbstractPatientsTablePage;
import com.manahealth.sv.ui.tests.application.pages.patients.PatientTabProvider;
import com.manahealth.sv.ui.tests.application.pages.patients.PatientsTableRequester;
import com.manahealth.sv.ui.tests.application.pages.patients.AbstractPatientsTablePage.TableItems;
import com.manahealth.sv.ui.tests.framework.assertions.IAssert;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class PatientTabStep extends BaseStep {

	public PatientsTableRequester page = new PatientsTableRequester(driver);
	public static final String EMPTY_VALUE = "---";

	public PatientTabStep(WebDriver driver) {
		super(driver);
	}

	public void openTab(RequestStatus status) {
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
		IAssert.assertEquals(baseTablePage.providerLbl.getText(), "Source");
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

	public void isReqPatientTableDataValid(int patientNumber, RequestStatus tab) {
		PatientRequesterDto dto = getRequeserPatientData(patientNumber, tab);
		isBasePatientDataValid(dto);
		regExpMatches(dto.getSubmitted(), "[0-9]{2}-[0-9]{2}-[0-9]{4}");
		if (!tab.equals(RequestStatus.PENDING)) {
			regExpMatches(dto.getActionDate(), "[0-9]{2}-[0-9]{2}-[0-9]{4}");
		}
	}
	
	public void isProvPatientTableDataValid(int patientNumber, RequestStatus tab) {
		PatientProviderDto dto = getProviderPatientData(patientNumber, tab);
		isBasePatientDataValid(dto);
		regExpMatches(dto.getRequested(), "[0-9]{2}-[0-9]{2}-[0-9]{4}");
		if (!tab.equals(RequestStatus.PENDING)) {
			regExpMatches(dto.getActionDate(), "[0-9]{2}-[0-9]{2}-[0-9]{4}");
		}
	}

	public int getPatientsCount() {
		return new AbstractPatientsTablePage(driver).abstarctPatientLbl.size();
	}

	public PatientRequesterDto getRequeserPatientData(int patientNumber, RequestStatus tab) {
		PatientRequesterDto patient = new PatientRequesterDto();
		ILabel absPatient = page.abstarctPatientLbl.get(patientNumber - 1);
		patient = (PatientRequesterDto) getBasicPatientData(patient, patientNumber);
		patient.setSource(getCellValue(absPatient, TableItems.SOURCE));
		patient.setSubmitted(getCellValue(absPatient, TableItems.SUMBITTED));
		if (!tab.equals(RequestStatus.PENDING)) {
			patient.setActionDate(getCellValue(absPatient, TableItems.ACTION));
		}
		return patient;
	}

	public PatientProviderDto getProviderPatientData(int patientNumber, RequestStatus tab) {
		PatientProviderDto patient = new PatientProviderDto();
		ILabel absPatient = page.abstarctPatientLbl.get(patientNumber - 1);
		patient = (PatientProviderDto) getBasicPatientData(patient, patientNumber);
		patient.setRequester(getCellValue(absPatient, TableItems.REQUESTER));
		patient.setRequested(getCellValue(absPatient, TableItems.REQUESTED));
		if (!tab.equals(RequestStatus.PENDING)) {
			patient.setActionDate(getCellValue(absPatient, TableItems.ACTION));
		}
		return patient;
	}
	
	public int getPatientCountFromPadding(){
		String label = page.paginationLbl.getText();
		System.out.println(label);
		Pattern p = Pattern.compile("\\([0-9]+");
		Matcher m = p.matcher(label);
		if(m.find()){
			String find = m.group(0);
			return Integer.parseInt(find.substring(1));
		}
		//TODO: check without pagination
		return -1;
	}
	
	public static void main(String []args){
		String dinf = "Page 1 of 4 (31 items) (32";
		Pattern p = Pattern.compile("\\([0-9]+");
		Matcher m = p.matcher(dinf);
		if(m.find()){
			String find = m.group(0);
			System.out.println(find);
		}
	}
	
	public void moveByPaddingNext(){
		page.paginationNextBtn.click();
	}
	
	private PatientDto getBasicPatientData(PatientDto patient, int patientNumber) {
		ILabel absPatient = page.abstarctPatientLbl.get(patientNumber - 1);
		patient.setName(getCellValue(absPatient, TableItems.NAME));
		patient.setDob(getCellValue(absPatient, TableItems.DOB));
		patient.setSex(getCellValue(absPatient, TableItems.SEX));
		patient.setSsn(getCellValue(absPatient, TableItems.SSN));
		patient.setAddress(getCellValue(absPatient, TableItems.ADDRESS));
		patient.setCity(getCellValue(absPatient, TableItems.CITY));
		patient.setState(getCellValue(absPatient, TableItems.STATE));
		patient.setZip(getCellValue(absPatient, TableItems.ZIP));
		return patient;
	}

	private void isBasePatientDataValid(PatientDto patient) {
		regExpMatches(patient.getName(), "([A-z]|[0-9])+, ([A-z]|[0-9])+");
		regExpMatches(patient.getDob(), "[0-9]{2}-[0-9]{2}-[0-9]{4}");
		regExpMatches(patient.getSex(), "[M|F]");
		regExpMatches(patient.getSsn(), "\\*[0-9]{4}");
	}

	private void regExpMatches(String stringToSearch, String regExp) {
		if (!stringToSearch.contains(EMPTY_VALUE)) {
			Pattern p = Pattern.compile(regExp);
			Matcher m = p.matcher(stringToSearch);
			IAssert.assertTrue(m.matches(), String.format("Patient data [%s] meets regexp [%s]", stringToSearch, regExp));
		}
	}

	private String getCellValue(ILabel patientRowItem, TableItems headerName) {
		return patientRowItem.getWrappedElement().findElements(By.xpath(".//td")).get(Integer.parseInt(headerName.getValue())).getText();
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

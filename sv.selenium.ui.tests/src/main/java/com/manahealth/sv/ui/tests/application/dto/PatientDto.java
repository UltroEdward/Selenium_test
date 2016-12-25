package com.manahealth.sv.ui.tests.application.dto;

import com.manahealth.sv.ui.tests.framework.elements.IButton;

public class PatientDto {

	private String fName;
	private String lName;
	private String dob;
	private String sex;
	private String ssn;
	private String address;
	private String city;
	private String state;
	private String zip;

	private IButton actionBtn;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public IButton getActionBtn() {
		return actionBtn;
	}

	public void setActionBtn(IButton actionBtn) {
		this.actionBtn = actionBtn;
	}

}

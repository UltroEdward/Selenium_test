package com.manahealth.sv.ui.tests.application.dto;

public class PatientProviderDto extends PatientDto{

	private String requester;
	private String requested;
	private String actionDate;
	
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	public String getRequested() {
		return requested;
	}
	public void setRequested(String requested) {
		this.requested = requested;
	}
	public String getActionDate() {
		return actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	
	
	
}

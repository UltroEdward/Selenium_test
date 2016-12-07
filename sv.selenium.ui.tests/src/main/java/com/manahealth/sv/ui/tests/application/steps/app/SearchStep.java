package com.manahealth.sv.ui.tests.application.steps.app;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

//TODO
public class SearchStep extends BaseStep {

	public SearchStep(WebDriver driver) {
		super(driver);
	}

	public void fillData(Object model) {

	}

	public List<Object> getResults(Object model) {
		fillData(model);
		return null;
	}

	// error msg
	public String getResultsNegative(Object model) {
		return null;
	}

}

package com.manahealth.sv.ui.tests.application.pages.patients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.ILabel;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class PatientsTableRequester extends BasePatientsTablePage {

	@FindBy(xpath = "//table//*[contains(text(), 'Source')]")
	public ILabel providerLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'Submitted')]")
	public ILabel submitedLbl;

	@FindBy(xpath = "//table//*[contains(text(), 'Approved')]")
	public ILabel approvedLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'Denied')]")
	public ILabel deniedLbl;

	public PatientsTableRequester(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

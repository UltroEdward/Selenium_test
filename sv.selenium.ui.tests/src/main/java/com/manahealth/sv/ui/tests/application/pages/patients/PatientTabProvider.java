package com.manahealth.sv.ui.tests.application.pages.patients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.ILabel;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class PatientTabProvider extends BasePatientsTablePage {

	@FindBy(xpath = "//table//th[contains(text(), 'Requester')]")
	public ILabel requesterLbl;	
	@FindBy(xpath = "//table//th[contains(text(), 'Requested')]")
	public ILabel requestedLbl;	
	@FindBy(xpath = "//table//th[contains(text(), 'Approved')]")
	public ILabel approvedLbl;	
	@FindBy(xpath = "//table//th[contains(text(), 'Denied')]")
	public ILabel deniedLbl;	
	
	public PatientTabProvider(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}



package com.manahealth.sv.ui.tests.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;
import com.manahealth.sv.ui.tests.framework.elements.IInput;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.elements.ISelect;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class SearchPage extends BasePage {

	private static final String LOAD_INDICATOR = "//h1[contains(@class, 'Search')][contains(@class, 'header')]";

	@FindBy(xpath = "//input[@name='firstName']")
	public IInput nameInp;
	@FindBy(xpath = "//input[@name='lastName']")
	public IInput lastNameInp;
	@FindBy(xpath = "//input[@name='dateOfBirth']")
	public IInput dayOfBirthInp;
	@FindBy(xpath = "//input[@name='ssn']")
	public IInput ssnInp;
	@FindBy(xpath = "//input[@name='address']")
	public IInput addressInp;
	@FindBy(xpath = "//input[@name='city']")
	public IInput cityInp;
	@FindBy(xpath = "//input[@name='zip']")
	public IInput zipInp;
	
	@FindBy(xpath = "//select[@name='sex']")
	public ISelect sexSel;
	
	
	@FindBy(xpath = "//*[contains(@class, 'icon-warning')]")
	public ILabel warnMsg;
	
	@FindBy(xpath = "//*[@type='submit']")
	public IButton submitBtn;
	@FindBy(xpath = "//*[@type='reset']")
	public IButton clearBtn;
	
	public SearchPage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

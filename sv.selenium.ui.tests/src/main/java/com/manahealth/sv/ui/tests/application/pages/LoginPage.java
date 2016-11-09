package com.manahealth.sv.ui.tests.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;
import com.manahealth.sv.ui.tests.framework.elements.IInput;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class LoginPage extends BasePage {

	private static final String LOAD_INDICATOR = "//input[@name='username']";
	
	@FindBy(xpath = "//input[@name='username']")
	public IInput userNameInp;
	@FindBy(xpath = "//input[@name='password']")
	public IInput passwordInp;
	@FindBy(xpath = "//*[@type='submit']")
	public IButton submitBtn;
	@FindBy(xpath = "//div[contains(@class, 'errorMessage')]")
	public ILabel errorAlertLbl;

	public LoginPage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

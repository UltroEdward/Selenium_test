package com.manahealth.sv.ui.tests.framework.pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class LoginPage extends BasePage {

	private static final String LOAD_INDICATOR = "//input[@name='username']";
	
	@FindBy(xpath = "//input[@name='username']")
	public TextInput userNameInp;
	@FindBy(xpath = "//input[@name='password']")
	public TextInput passwordInp;
	@FindBy(xpath = "//*[@type='submit']")
	public Button submitBtn;
	@FindBy(xpath = "//div[contains(@class, 'errorMessage')]")
	public Link errorAlertLbl;

	public LoginPage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

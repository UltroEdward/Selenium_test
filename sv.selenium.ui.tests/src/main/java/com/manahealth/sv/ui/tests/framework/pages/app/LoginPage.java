package com.manahealth.sv.ui.tests.framework.pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.manahealth.sv.ui.tests.framework.pages.BasePage;

public class LoginPage extends BasePage {

	private static final String LOAD_INDICATOR = "//input[@name='username']";
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userNameInp;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordInp;
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement submitBtn;
	@FindBy(xpath = "//div[contains(@class, 'errorMessage')]")
	public WebElement errorAlertLbl;

	public LoginPage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
	}

}
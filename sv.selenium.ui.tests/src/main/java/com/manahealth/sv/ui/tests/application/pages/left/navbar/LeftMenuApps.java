package com.manahealth.sv.ui.tests.application.pages.left.navbar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class LeftMenuApps extends BasePage {

	private static final String LOAD_INDICATOR = "//nav/*[contains(@class, 'requests')]";
	
	@FindBy(xpath = "//a[contains(@class, 'logo')]")
	public IButton goToHomeLogoBtn;
	@FindBy(xpath = "//nav/*[contains(@class, 'requests')]")
	public IButton goToRequestsBtn;
	@FindBy(xpath = "//nav/*[contains(@class, 'search')]")
	public IButton goToSearchBtn;

	public LeftMenuApps(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}
	
}

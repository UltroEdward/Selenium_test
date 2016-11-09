package com.manahealth.sv.ui.tests.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class HomePage extends BasePage{

	private static final String LOAD_INDICATOR = "//a[contains(@class, 'logo')]";
	
	@FindBy(xpath = "//header//*[contains(@class, 'title')]")
	public ILabel userTitleLbl;
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}
	
}

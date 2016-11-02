package com.manahealth.sv.ui.tests.framework.pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class HomePage extends BasePage{

	private static final String LOAD_INDICATOR = "//a[contains(@class, 'logo')]";
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

package com.manahealth.sv.ui.tests.application.pages.left.navbar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class ReqLeftAppMenuPage extends AbstarctLeftAppMenuPage{

	@FindBy(xpath = "//nav/*[contains(@class, 'search')]")
	public IButton goToSearchBtn;
	
	public ReqLeftAppMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

}

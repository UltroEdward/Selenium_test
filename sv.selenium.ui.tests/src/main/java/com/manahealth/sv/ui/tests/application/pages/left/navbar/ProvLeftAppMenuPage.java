package com.manahealth.sv.ui.tests.application.pages.left.navbar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class ProvLeftAppMenuPage extends AbstarctLeftAppMenuPage {

	public ProvLeftAppMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}
}

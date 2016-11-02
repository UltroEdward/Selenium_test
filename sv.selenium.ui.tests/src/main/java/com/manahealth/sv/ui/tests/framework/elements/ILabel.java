package com.manahealth.sv.ui.tests.framework.elements;

import org.openqa.selenium.WebElement;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;



public class ILabel extends TypifiedElement{

	public ILabel(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public String getText() {
		String actualText = getWrappedElement().getText();
		ReportManager.getInstance().reportStep(LogStatus.INFO, String.format("Getting text from [%s]: %s ", getName(), actualText));
		return actualText;
	}
		
}

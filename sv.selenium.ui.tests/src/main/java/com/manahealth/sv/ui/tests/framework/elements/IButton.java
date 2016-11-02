package com.manahealth.sv.ui.tests.framework.elements;

import org.openqa.selenium.WebElement;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.htmlelements.element.Button;

public class IButton extends Button {

	public IButton(WebElement wrappedElement) {
		super(wrappedElement);
	}
	
	@Override
	public void click() {
		super.click();
		ReportManager.getInstance().reportStep(LogStatus.INFO, String.format("Button pressed [%s]", getName()));
	}

}

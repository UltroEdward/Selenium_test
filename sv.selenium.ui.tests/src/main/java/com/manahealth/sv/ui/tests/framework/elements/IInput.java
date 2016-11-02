package com.manahealth.sv.ui.tests.framework.elements;

import org.openqa.selenium.WebElement;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.htmlelements.element.TextInput;

public class IInput extends TextInput {

	public IInput(WebElement wrappedElement) {
		super(wrappedElement);
	}

	@Override
	public void sendKeys(CharSequence... keys) {
		super.sendKeys(keys);
		ReportManager.getInstance().reportStep(LogStatus.INFO,
				String.format("Sending text to [%s]: %s", getName(),keys[0] ));
	}

	@Override
	public String getEnteredText() {
		String actualText = super.getEnteredText();
		ReportManager.getInstance().reportStep(LogStatus.INFO,
				String.format("Getting text from [%s]: %s " + getName(), actualText));
		return actualText;
	}
}

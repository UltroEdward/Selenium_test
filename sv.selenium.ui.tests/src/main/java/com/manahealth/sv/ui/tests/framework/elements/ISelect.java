package com.manahealth.sv.ui.tests.framework.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ISelect extends TypifiedElement {

	public ISelect(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public String getValue() {
		String value = getWrappedElement().findElement(By.xpath(".//parent::*//input[@type='text']")).getAttribute("value");
		ReportManager.getInstance().reportStep(LogStatus.INFO, String.format("Getting value from [%s]: %s ", getName(), value));
		return value;
	}

	public void setValue(String value) {
		getWrappedElement().findElement(By.xpath(".//parent::*//input[@type='text']")).click();
		List<WebElement> options = getWrappedElement().findElements(By.xpath("//span[contains(@value,.)]"));
		for (WebElement el : options) {
			if (el.getAttribute("value").equalsIgnoreCase(value)) {
				el.click();
				ReportManager.getInstance().reportStep(LogStatus.INFO, String.format("Setting value to [%s]: %s ", getName(), value));
				return;
			}
		}
		ReportManager.getInstance().reportStep(LogStatus.ERROR, String.format("Can't set to [%s]:  value %s ", getName(), value));
	}

	public List<String> getOptions() {
		List<WebElement> options = getWrappedElement().findElements(By.xpath(".//option"));
		List<String> result = new ArrayList<String>();
		for (WebElement el : options) {
			String value = el.getAttribute("value");
			if (value != null && !value.isEmpty()) {
				result.add(value);
			}
		}
		return result;
	}

}
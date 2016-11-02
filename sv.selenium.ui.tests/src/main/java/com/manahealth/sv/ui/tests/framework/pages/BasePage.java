package com.manahealth.sv.ui.tests.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	private static final int DEFAULT_WAIT_TIME = 45;
	private WebDriver driver = null;
	private static final Logger log = LoggerFactory.getLogger(BasePage.class);
	private ReportManager reporter = ReportManager.getInstance();

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void waitForPageToLoad(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			String infMsg = String.format("Page [%s] is loaded", this.getClass().getSimpleName());
			log.info(infMsg);
			reporter.reportStep(LogStatus.INFO, infMsg);
		} catch (WebDriverException ex) {
			String errMsg = String.format("Page [%s] is NOT loaded correctly, can't find indicator: (%s). \nERROR: %s", this.getClass().getSimpleName(), xpathExpression, ex.getMessage());
			log.error(errMsg);
			reporter.reportStep(LogStatus.ERROR, errMsg);
			throw new RuntimeException(ex);
		}
	}

}

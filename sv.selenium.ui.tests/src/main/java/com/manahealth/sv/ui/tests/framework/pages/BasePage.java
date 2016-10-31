package com.manahealth.sv.ui.tests.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

	private WebDriver driver = null;
	private static final Logger log = LoggerFactory.getLogger(BasePage.class);
	private static final int DEFAULT_WAIT_TIME = 99;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void waitForPageToLoad(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			log.info(String.format("Page [%s] is loaded", this.getClass().getSimpleName()));
		} catch (WebDriverException ex) {
			log.error(String.format("Page [%s] is NOT loaded correctly, can't find indicator: (%s). \nERROR: %s", this.getClass().getSimpleName(), xpathExpression, ex.getMessage()));
			throw new RuntimeException(ex);
		}
	}

}
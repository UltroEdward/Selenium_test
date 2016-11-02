package com.manahealth.sv.ui.tests.testcases.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.framework.driver.AppContext;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.driver.DriverType;
import com.manahealth.sv.ui.tests.framework.report.ReportManager;

public abstract class BaseTest {

	protected WebDriver driver = null;
	protected AppContext appContext = null;
	private ReportManager reporter = ReportManager.getInstance();

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitWebDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method m, ITestContext context) {
		driver = DriverFactory.getWebDriver(appContext.getDriver());
		driver.get(appContext.getBaseUrl());
		reporter.startTest(m.getName(), m.getAnnotation(Test.class).description());
	}

	@Parameters({ "BASE_URL", "REPORT_PATH", "USERNAME", "PASSWORD", "DRIVER" })
	@BeforeClass
	public void setUpContext(@Optional String baseUrl, @Optional String reportPath, @Optional String username,
			@Optional String password, @Optional String driver) {
		appContext = AppContext.getInstance();
		appContext.setBaseUrl(baseUrl);
		appContext.setReportPath(reportPath);
		appContext.setDriver(DriverType.valueOf(driver));
		appContext.setUsername(username);
		appContext.setPassword(password);
		
		reporter.init();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		reporter.endReport();
	}
	
}

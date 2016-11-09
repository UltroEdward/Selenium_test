package com.manahealth.sv.ui.tests.testcases.tests;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	protected AppContext appContext = null;
	protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	private ReportManager reporter = ReportManager.getInstance();
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitWebDriver(DriverFactory.getDriver());
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method m, ITestContext context) {
		DriverFactory.setDriver(appContext.getDriver());
		DriverFactory.getDriver().get(appContext.getBaseUrl());
		reporter.startTest(m.getName(), m.getAnnotation(Test.class).description());
	}

	@Parameters({ "BASE_URL", "REPORT_PATH", "USERNAME_PROV", "PASSWORD_PROV", "USERNAME_REQ", "PASSWORD_REQ", "DRIVER" })
	@BeforeClass
	public void setUpContext(@Optional String baseUrl, @Optional String reportPath, @Optional String usernameProv, @Optional String passwordProv,
			@Optional String usernameReq, @Optional String passwordReq, @Optional String driver) {

		appContext = AppContext.getInstance();

		appContext.setBaseUrl(baseUrl);
		appContext.setReportPath(reportPath);
		appContext.setDriver(DriverType.valueOf(driver));
		appContext.setUsernameProv(usernameProv);
		appContext.setPasswordProv(passwordProv);
		appContext.setUsernameReq(usernameReq);
		appContext.setPasswordReq(passwordReq);

		reporter.init();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		reporter.endReport();
	}

}

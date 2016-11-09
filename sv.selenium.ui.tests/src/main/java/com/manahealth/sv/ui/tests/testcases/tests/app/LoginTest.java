package com.manahealth.sv.ui.tests.testcases.tests.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.application.steps.app.LoginStep;
import com.manahealth.sv.ui.tests.framework.assertions.IAssert;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;

import com.manahealth.sv.ui.tests.testcases.tests.BaseTest;

public class LoginTest extends BaseTest {

	private static final String CONTACT_TO_ADMIN_ALERT = "Please email support@manahealth.com for assistance";

	@DataProvider
	public String[][] wrongCredentials() {
		return new String[][] { { "qwerty@qwerty.ru", "qwerty" } };
	}

	@DataProvider
	public String[][] credentials() {
		return new String[][] { { appContext.getUsernameProv(), appContext.getPasswordProv() }, { appContext.getUsernameReq(), appContext.getPasswordReq() } };
	}

	@Test(dataProvider = "credentials", description = "User can be authorized, and see dashboard after authorization")
	public void loginPositive(String username, String password) {
		LoginStep loginStep = new LoginStep(DriverFactory.getDriver());
		loginStep.login(username, password);
	}

	@Test(description = "User again see log-in page after refreshing logi-in page with no authorization data")
	public void loginPageAvailableAfterRefresh() {
		new LoginStep(DriverFactory.getDriver());
		DriverFactory.getDriver().navigate().refresh();
		new LoginStep(DriverFactory.getDriver());
	}

	@Test(dataProvider = "wrongCredentials", description = "User can't be authorized with wrong credentials")
	public void loginWrongCreds(String username, String password) {
		LoginStep loginStep = new LoginStep(DriverFactory.getDriver());
		String errMsg = loginStep.loginNegative(username, password);
		IAssert.assertTrue(errMsg.contains("The email address or password you typed in is incorrect"));
		IAssert.assertTrue(errMsg.contains(CONTACT_TO_ADMIN_ALERT), "Alert msg contains: " + CONTACT_TO_ADMIN_ALERT);
	}

	@Test(description = "User see error msg for empty email")
	public void logInWithEmptyEmail() {
		LoginStep loginStep = new LoginStep(DriverFactory.getDriver());
		String errMsg = loginStep.loginNegative("", "qwerty");
		IAssert.assertTrue(errMsg.contains("Email address is required"));
		IAssert.assertTrue(errMsg.contains(CONTACT_TO_ADMIN_ALERT), "Alert msg contains: " + CONTACT_TO_ADMIN_ALERT);
	}

	@Test(description = "User see error msg for empty password")
	public void logInWithEmptyPassword() {
		LoginStep loginStep = new LoginStep(DriverFactory.getDriver());
		String errMsg = loginStep.loginNegative("abc@example.com", "");
		IAssert.assertTrue(errMsg.contains("Password is required"));
		IAssert.assertTrue(errMsg.contains(CONTACT_TO_ADMIN_ALERT), "Alert msg contains: " + CONTACT_TO_ADMIN_ALERT);
	}

}

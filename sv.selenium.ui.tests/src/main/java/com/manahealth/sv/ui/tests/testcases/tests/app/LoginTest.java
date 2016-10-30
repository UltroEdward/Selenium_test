package com.manahealth.sv.ui.tests.testcases.tests.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.framework.steps.app.LoginStep;
import com.manahealth.sv.ui.tests.testcases.tests.BaseTest;

public class LoginTest extends BaseTest {

	LoginStep loginStep = new LoginStep(driver);
	
	@DataProvider
	public String[][] worngCredentials() {
		return new String[][] { { "qwerty@qwerty.ru", "qwerty" }, { "123456@123456.ru", "qwerty" }, };
	}

	@Test(dataProvider = "worngCredentials", description="User can't be authorized with wrong credentials")
	public void loginWrongCreds(String username, String password) {
		loginStep.loginNegative(username, password);
	}

	@Test
	public void loginPositive() {

	}

}

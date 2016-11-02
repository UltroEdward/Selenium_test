package com.manahealth.sv.ui.tests.framework.steps.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.framework.pages.app.LoginPage;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class LoginStep extends BaseStep {

	public LoginPage loginPage = new LoginPage(driver);
	 
	public LoginStep(WebDriver driver) {
		super(driver);	
	}
 
	public HomeStep login(String username, String password) {
		loginDefault(username, password);
		return new HomeStep(driver);
	}
	
	public String loginNegative(String username, String password) {
		loginDefault(username, password);
		String alertMsg = loginPage.errorAlertLbl.getText();
		assertThat(alertMsg.contains("The email address or password you typed in is incorrect"));
		return null;
	}
	
	private void loginDefault(String username, String password) {
		loginPage.userNameInp.sendKeys(username);
		loginPage.passwordInp.sendKeys(password);
		loginPage.submitBtn.click();
	}

}

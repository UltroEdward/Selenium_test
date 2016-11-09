package com.manahealth.sv.ui.tests.application.steps.app;

import org.openqa.selenium.WebDriver;

import com.manahealth.sv.ui.tests.application.pages.LoginPage;
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
		return alertMsg;
	}
	
	public HomeStep loginAsProv() {
		return login(context.getUsernameProv(), context.getPasswordProv() );
	}
	
	public HomeStep loginAsReq() {
		return login(context.getUsernameReq(), context.getPasswordReq() );
	}
	
	private void loginDefault(String username, String password) {
		loginPage.userNameInp.sendKeys(username);
		loginPage.passwordInp.sendKeys(password);
		loginPage.submitBtn.click();
	}

}

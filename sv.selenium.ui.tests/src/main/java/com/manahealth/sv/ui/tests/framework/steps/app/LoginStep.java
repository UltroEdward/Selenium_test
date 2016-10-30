package com.manahealth.sv.ui.tests.framework.steps.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.*;

import com.manahealth.sv.ui.tests.framework.pages.app.HomePage;
import com.manahealth.sv.ui.tests.framework.pages.app.LoginPage;
import com.manahealth.sv.ui.tests.framework.steps.BaseStep;

public class LoginStep extends BaseStep {

	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

	public LoginStep(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String username, String password) {
		loginDefault(username, password);
		return new HomePage(driver);
	}
	
	public String loginNegative(String username, String password) {
		loginDefault(username, password);
		String alertMsg = loginPage.errorAlertLbl.getText();
		assertThat(alertMsg.contains("The email address or password you typed in is incorrect"));
		return alertMsg;
	}
	
	private void loginDefault(String username, String password) {
		driver.get("");
		loginPage.userNameInp.sendKeys(username);
		loginPage.passwordInp.sendKeys(password);
		loginPage.submitBtn.click();
	}

}

package com.manahealth.sv.ui.tests.framework.driver;

import com.manahealth.sv.ui.tests.framework.utils.Config;

public class AppContext {

	private static AppContext appContext;
	private String baseUrl = null;
	private String reportPath = null;
	private DriverType driver = null;
	private String usernameProv = null;
	private String passwordProv = null;
	private String usernameReq = null;
	private String passwordReq = null;

	private AppContext() {
	}

	public static synchronized AppContext getInstance() {
		if (appContext == null) {
			appContext = new AppContext();
		}
		return appContext;
	}

	public String getBaseUrl() {
		if (baseUrl == null) {
			baseUrl = Config.getValue("BASE_URL");
		}
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public DriverType getDriver() {
		if (driver == null) {
			driver = DriverType.valueOf(Config.getValue("DRIVER"));
		}
		return driver;
	}

	public void setDriver(DriverType driver) {
		this.driver = driver;
	}

	public String getUsernameProv() {
		return usernameProv;
	}

	public void setUsernameProv(String usernameProv) {
		this.usernameProv = usernameProv;
	}

	public String getPasswordProv() {
		return passwordProv;
	}

	public void setPasswordProv(String passwordProv) {
		this.passwordProv = passwordProv;
	}

	public String getUsernameReq() {
		return usernameReq;
	}

	public void setUsernameReq(String usernameReq) {
		this.usernameReq = usernameReq;
	}

	public String getPasswordReq() {
		return passwordReq;
	}

	public void setPasswordReq(String passwordReq) {
		this.passwordReq = passwordReq;
	}

}

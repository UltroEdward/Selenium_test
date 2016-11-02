package com.manahealth.sv.ui.tests.framework.driver;

import com.manahealth.sv.ui.tests.framework.utils.Config;

public class AppContext {

	private static AppContext appContext;

	private AppContext() {
	}

	public static synchronized AppContext getInstance() {
		if (appContext == null) {
			appContext = new AppContext();
		}
		return appContext;
	}

	private String baseUrl = null;
	private String reportPath = null;
	private DriverType driver = null;
	private String username = null;
	private String password = null;

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

	public String getUsername() {
		if (username == null) {
			username = Config.getValue("USERNAME");
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		if (password == null) {
			password = Config.getValue("PASSWORD");
		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.manahealth.sv.ui.tests.framework.driver;

import com.manahealth.sv.ui.tests.framework.utils.Config;

public class Context {

	private static Context context;
	
	private Context(){
		
	}

	public static synchronized Context getInstance() {
		if (context == null) {
			context = new Context();
		}
		return context;
	}

	private String baseUrl = null;
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

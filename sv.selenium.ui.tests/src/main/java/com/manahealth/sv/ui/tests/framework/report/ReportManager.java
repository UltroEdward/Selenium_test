package com.manahealth.sv.ui.tests.framework.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.manahealth.sv.ui.tests.framework.driver.AppContext;
import com.manahealth.sv.ui.tests.framework.utils.DateUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportManager {

	private static ReportManager manager;
	private ExtentReports report;
	static Map<Integer, ExtentTest> reportPerThread = new HashMap<Integer, ExtentTest>();

	private ReportManager() {
	}

	public static synchronized ReportManager getInstance() {
		if (manager == null) {
			manager = new ReportManager();
		}
		return manager;
	}

	public void init() {
		if (report == null) {
			report = new ExtentReports(AppContext.getInstance().getReportPath() + File.separator
					+ String.format("Report_%s.html", DateUtils.getCurDate()));
		}
	}

	private synchronized ExtentTest getTest() {
		return reportPerThread.get(Integer.valueOf((int) Thread.currentThread().getId()));
	}

	public synchronized void endTest() {
		report.endTest(reportPerThread.get(Integer.valueOf((int) Thread.currentThread().getId())));
	}

	public synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = report.startTest(testName, description);
		reportPerThread.put(Integer.valueOf((int) Thread.currentThread().getId()), test);
		return test;
	}

	public void endReport() {
		report.close();
	}

	public void reportStep(LogStatus status, String eventName) {
		this.getTest().log(status, eventName);
	}


	

}
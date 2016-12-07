package com.manahealth.sv.ui.tests.framework.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.manahealth.sv.ui.tests.framework.utils.DateUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportManager {

	private ExtentReports report;
	private static ReportManager manager;
	private static Map<Integer, ExtentTest> reportPerThread = new HashMap<Integer, ExtentTest>();

	private ReportManager() {
	}

	public static synchronized ReportManager getInstance() {
		if (manager == null) {
			manager = new ReportManager();
		}
		return manager;
	}

	public void initReport(String reportPath) {
		if (report == null) {
			report = new ExtentReports(reportPath + File.separator + String.format("Report_%s.html", DateUtils.getCurDate()));
		}
	}

	public synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = report.startTest(testName, description);
		reportPerThread.put(Integer.valueOf((int) Thread.currentThread().getId()), test);
		return test;
	}

	public void reportStep(LogStatus status, String eventName) {
		if (eventName == null || eventName.isEmpty()) {
			eventName = "No description";
		}
		this.getTest().log(status, eventName);
	}

	public synchronized void endTest() {
		report.endTest(reportPerThread.get(Integer.valueOf((int) Thread.currentThread().getId())));
	}

	public void endReport() {
		report.close();
	}

	private synchronized ExtentTest getTest() {
		return reportPerThread.get(Integer.valueOf((int) Thread.currentThread().getId()));
	}
}
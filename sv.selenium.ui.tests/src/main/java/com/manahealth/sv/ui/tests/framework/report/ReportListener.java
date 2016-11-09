package com.manahealth.sv.ui.tests.framework.report;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import com.relevantcodes.extentreports.LogStatus;

public class ReportListener implements IResultListener, IInvokedMethodListener {
	private ReportManager reporter = ReportManager.getInstance();

	public void onTestSkipped(ITestResult tr) {
		reporter.reportStep(LogStatus.SKIP, "Skipped test [" + Thread.currentThread().getName() + "] : "+ tr.getName() + " " + tr.getThrowable().getMessage());
		reporter.endTest();
	}

	public void onTestFailure(ITestResult tr) {
		reporter.reportStep(LogStatus.FAIL, "Finish test [" + Thread.currentThread().getName() + "] with failure");
		reporter.endTest();
	}

	public void onTestSuccess(ITestResult tr) {
		reporter.reportStep(LogStatus.PASS, "Finish test [" + Thread.currentThread().getName() + "] with success");
		reporter.endTest();
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
	}

	public void onConfigurationSuccess(ITestResult itr) {
	}

	public void onConfigurationFailure(ITestResult itr) {
	}

	public void onConfigurationSkip(ITestResult itr) {
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	public void onFinish(ITestContext context) {
		
	}

}

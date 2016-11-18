package com.manahealth.sv.ui.tests.framework.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.manahealth.sv.ui.tests.framework.driver.DriverUtils;
import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class IAssert {

	private static ReportManager reporter = ReportManager.getInstance();
	private static final String FAILED_TEMPLATE = "Assert fails: [%s]. <br>";

	public static void assertTrue(boolean condition) {
		try {
			assertThat(condition).isEqualTo(true);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: [%s] is [true]", condition));
		} catch (AssertionError ex) {
			reportFailture(ex);
			throw new AssertionError(ex);
		}
	}

	public static void assertTrue(boolean condition, String description) {
		try {
			assertThat(condition).isEqualTo(true);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: [%s] is [true]. Description: %s", condition, description));
		} catch (AssertionError ex) {
			reportFailture(ex, description);
			throw new AssertionError(ex + "\n Assertion failed: " + description);
		}
	}

	public static void assertEquals(Object actual, Object expected) {
		try {
			assertThat(actual).isEqualTo(expected);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: <br> [%s] equals to [%s]", actual.toString(), expected.toString()));
		} catch (AssertionError ex) {
			reportFailture(ex);
			throw new AssertionError(ex);
		}
	}

	public static void reportFailture(Throwable ex, String description) {
		reporter.reportStep(LogStatus.ERROR, String.format(FAILED_TEMPLATE, ex.getMessage()));
		if (description != null && !description.isEmpty()){
			reporter.reportStep(LogStatus.ERROR, String.format("Assertion fails: %s ", description));
		}
		
		DriverUtils.reportScreenShotFailture();
		reporter.reportStep(LogStatus.ERROR, "StackTrace: <br>" + stackTraceToString(ex));
	}
	
	private static void reportFailture(AssertionError ex) {
		reportFailture(ex, null);
	}

	private static String stackTraceToString(Throwable e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n <br>");
		}
		return sb.toString();
	}

}

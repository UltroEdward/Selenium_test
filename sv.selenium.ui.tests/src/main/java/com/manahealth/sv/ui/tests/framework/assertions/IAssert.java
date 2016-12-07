package com.manahealth.sv.ui.tests.framework.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.manahealth.sv.ui.tests.framework.utils.AssertUtils;
import com.relevantcodes.extentreports.LogStatus;

public class IAssert {

	private static ReportManager reporter = ReportManager.getInstance();
	private static final String FAILED_TEMPLATE = "Assert fails: [%s]. <br>";

	public static void assertTrue(boolean condition) {
		assertTrue(condition, null);
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

		if (description != null && !description.isEmpty()) {
			reporter.reportStep(LogStatus.ERROR, String.format("Assertion fails: %s ", description));
		}

		AssertUtils.reportScreenShotFailture();
		reporter.reportStep(LogStatus.ERROR, "StackTrace: <br>" + AssertUtils.stackTraceToString(ex));
	}

	public static void reportFailture(AssertionError ex) {
		reportFailture(ex, null);
	}

}

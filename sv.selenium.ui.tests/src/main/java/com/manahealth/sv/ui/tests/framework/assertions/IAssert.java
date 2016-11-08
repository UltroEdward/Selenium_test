package com.manahealth.sv.ui.tests.framework.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class IAssert {

	private static ReportManager reporter = ReportManager.getInstance();

	public static void assertTrue(boolean condition) {
		try {
			assertThat(condition).isEqualTo(true);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: [%s] is [true]", condition));
		} catch (Exception ex) {
			reporter.reportStep(LogStatus.ERROR,
					String.format("Assert fails: [%s]. <br>Trace: %s", ex.getMessage(), ex.getStackTrace()));
		}
	}

	public static void assertEquals(Object actual, Object expected) {
		try {
			assertThat(actual).isEqualTo(expected);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: <br> [%s] equals to <br>[]",
					actual.toString(), expected.toString()));
		} catch (Exception ex) {
			reporter.reportStep(LogStatus.ERROR,
					String.format("Assert fails: [%s]. <br>Trace: %s", ex.getMessage(), ex.getStackTrace()));
		}
	}

}

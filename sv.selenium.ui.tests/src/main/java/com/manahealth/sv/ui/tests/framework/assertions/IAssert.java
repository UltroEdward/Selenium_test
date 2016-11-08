package com.manahealth.sv.ui.tests.framework.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.manahealth.sv.ui.tests.framework.driver.AppContext;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.manahealth.sv.ui.tests.framework.utils.DateUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IAssert {

	private static ReportManager reporter = ReportManager.getInstance();
	private static final String FAILED_TEMPLATE = "Assert fails: [%s]. <br>";

	public static void assertTrue(boolean condition) {
		try{
		assertThat(condition).isEqualTo(true); 
		reporter.reportStep(LogStatus.PASS, String.format("Assert success: [%s] is [true]", condition));
		}catch (AssertionError  ex) {
			reporter.reportStep(LogStatus.ERROR, String.format(FAILED_TEMPLATE, ex.getMessage()));
			reportScreenShotFailture();
			reporter.reportStep(LogStatus.ERROR, "StackTrace: <br>" + stackTraceToString(ex));
			throw new AssertionError(ex);
		}
	}

	public static void assertTrue(boolean condition, String description) {
		try {
			assertThat(condition).isEqualTo(true);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: [%s] is [true]. Description: %s", condition, description));
		} catch (AssertionError ex) {
			reporter.reportStep(LogStatus.ERROR, String.format(FAILED_TEMPLATE, ex.getMessage()));
			reportScreenShotFailture();
			reporter.reportStep(LogStatus.ERROR, "StackTrace: <br>" + stackTraceToString(ex));
			throw new AssertionError(ex);
		}
	}

	public static void assertEquals(Object actual, Object expected) {
		try {
			assertThat(actual).isEqualTo(expected);
			reporter.reportStep(LogStatus.PASS, String.format("Assert success: <br> [%s] equals to <br>[]", actual.toString(), expected.toString()));
		} catch (AssertionError ex) {
			reporter.reportStep(LogStatus.ERROR, String.format(FAILED_TEMPLATE, ex.getMessage()));
			reportScreenShotFailture();
			reporter.reportStep(LogStatus.ERROR, "StackTrace: <br>" + stackTraceToString(ex));
			throw new AssertionError(ex);
		}
	}

	private static void reportScreenShotFailture() {
		ExtentTest test = new ExtentTest("test", "test");
		File screenShot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = AppContext.getInstance().getReportPath() + "ScreenShots" + File.separator + String.format("SH_%s.png", DateUtils.getCurDate());
		try {
			FileUtils.copyFile(screenShot, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		reporter.reportStep(LogStatus.ERROR, test.addScreenCapture(path));
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

package com.manahealth.sv.ui.tests.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manahealth.sv.ui.tests.framework.assertions.IAssert;
import com.manahealth.sv.ui.tests.framework.driver.AppContext;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AssertUtils {

	private static final Logger log = LoggerFactory.getLogger(AssertUtils.class);

	public static void regExpMatchesValidator(String stringToSearch, String regExp) {
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(stringToSearch);
		IAssert.assertTrue(m.matches(), String.format("Data [%s] meets regexp [%s]", stringToSearch, regExp));
	}

	public static String stackTraceToString(Throwable e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n <br>");
		}
		return sb.toString();
	}
	
	public static void reportScreenShotFailture() {
		File screenShot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = AppContext.getInstance().getReportPath() + "ScreenShots" + File.separator + String.format("SH_%s.png", DateUtils.getCurDate());
		
		try {
			FileUtils.copyFile(screenShot, new File(path));
		} catch (IOException e) {
			log.error(String.format("Can't write file to path: [%s], error is: ", path, e.getMessage()));
		}
		
		ReportManager.getInstance().reportStep(LogStatus.ERROR, new ExtentTest("Failed test", "ScreenShot").addScreenCapture(path));
	}
	
	
}

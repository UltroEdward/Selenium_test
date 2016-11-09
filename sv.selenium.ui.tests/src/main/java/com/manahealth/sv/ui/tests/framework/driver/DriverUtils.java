package com.manahealth.sv.ui.tests.framework.driver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manahealth.sv.ui.tests.framework.report.ReportManager;
import com.manahealth.sv.ui.tests.framework.utils.DateUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverUtils {

	private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);
	
	public static void reportScreenShotFailture() {
		ExtentTest test = new ExtentTest("Failed test", "ScreenShot");
		File screenShot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = AppContext.getInstance().getReportPath() + "ScreenShots" + File.separator + String.format("SH_%s.png", DateUtils.getCurDate());
		try {
			FileUtils.copyFile(screenShot, new File(path));
		} catch (IOException e) {
			log.error(String.format("Can't write file to path: [%s], error is: ", path, e.getMessage()));
		}
		ReportManager.getInstance().reportStep(LogStatus.ERROR, test.addScreenCapture(path));
	}
}

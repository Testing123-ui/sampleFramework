package com.sampleframework.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sampleframework.testCases.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, "Test Case Passed : " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, result.getThrowable().getMessage());

		captureScreenshot(result.getName());

		if (destFile.exists()) {
			try {
				logger.fail("Screenshot attached below : " + logger.addScreenCaptureFromPath("." + destFile));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, "Test Case Skipped :" + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		spark = new ExtentSparkReporter("./test-output/extentreports_" + date + ".html");
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Functional Testing Report");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester", "Sravanthi");
		extent.setSystemInfo("Machine", "LocalHost");

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}

package Utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestCases.Base;



public class Reports extends Base implements ITestListener{
	
ExtentReports extent = ExtentReportCreation.getReport();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	test.log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		String ssPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getMethod().getMethodName() + ".png";
		
		File f = new File(ssPath);
		if (f.exists())
		{
			test.addScreenCaptureFromPath(ssPath);
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

	
	
}

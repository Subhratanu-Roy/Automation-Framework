package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCreation {
	static ExtentReports extent;
	public static ExtentReports getReport()
	{
	
		String path = System.getProperty("user.dir") + "\\TestReports\\index.html";
		ExtentSparkReporter rep =  new ExtentSparkReporter(path);
	
	rep.config().setReportName("Guru99 Test Automation");
	rep.config().setDocumentTitle("Automation Testing Report");
	extent = new ExtentReports();
	extent.attachReporter(rep);
	extent.setSystemInfo("Tester", "Subhratanu Roy");
	return extent;

	}
	
	
}

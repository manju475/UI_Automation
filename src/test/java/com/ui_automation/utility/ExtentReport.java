package com.ui_automation.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; //creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(("user.dir")+"/reports/myReport.html"); //specific folder
		
		sparkReporter.config().setDocumentTitle("UI_Automation Result"); //Title of the report
		sparkReporter.config().setReportName("Functional Testing"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK); 
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "Demo site");
		extent.setSystemInfo("Tester Name", "manjunatha");
		extent.setSystemInfo("OS", "Mac");
		extent.setSystemInfo("Browser name", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); //update status p/f/s
		
	}

}

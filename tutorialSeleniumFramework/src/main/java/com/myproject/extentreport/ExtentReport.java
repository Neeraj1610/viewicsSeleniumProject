package com.myproject.extentreport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class for reporting.
 * 
 * @author nadhikari
 *
 */
public class ExtentReport {

	private static ExtentReports extentReports;
	private static ExtentTest extentTest;


	public void intializeExtentReportAndStartTest(String filePath, boolean replaceExistingFile, String testName, String testDescription)
	{
		extentReports=new ExtentReports(filePath, replaceExistingFile);
		extentTest=extentReports.startTest(testName, testDescription);
	}

	public void logExtentReport()
	{

		extentReports.endTest(extentTest);
		extentReports.flush();
	}

	public static void extentReportSuccessMsg(String description)
	{
		extentTest.log(LogStatus.PASS, description);
	}

	public static void extentReportFailMsg(String description)
	{
		extentTest.log(LogStatus.FAIL, description);
	}
}
package com.crm.Listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;

public class Listner_Create_Org_With_Industry extends BaseClass implements ITestListener
{
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		String t_name=result.getMethod().getMethodName();
		Reporter.log(t_name+"is Executed");
		test=report.createTest(t_name);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.PASS, t_name+"is Success");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.FAIL, t_name+"is Failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String screenshot=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.SKIP,t_name+"is Skipped");
	}

	@Override
	public void onStart(ITestContext context)
	{
		spark=new ExtentSparkReporter("./ExtendReport/CreateIndustry.html");
		spark.config().setDocumentTitle("Krushnali");
		spark.config().setReportName("createIndustry");
		spark.config().setTheme(Theme.DARK);
		
		report.setSystemInfo("Os", "window-10");
		report.setSystemInfo("Browser", "Chrome-100");
		
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}

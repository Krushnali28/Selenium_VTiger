package com.crm.Listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
public class ListnersCreate_org extends BaseClass implements ITestListener 
{

	ExtentReports report;
	ExtentTest test;
	ExtentSparkReporter spark;
	

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
		test.log(Status.PASS,t_name+"is Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.FAIL,t_name+"is Failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String Screenshot=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(Screenshot);
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.SKIP, t_name+"is Skipped");

	}
	@Override
	public void onStart(ITestContext context)
	{
		//Create Spark Reporter
				 spark=new ExtentSparkReporter("./ExtendReport/CreateReport.html");
				//Configure the Spark Reporter
				spark.config().setDocumentTitle("Report");
				spark.config().setReportName("krushnali");
				spark.config().setTheme(Theme.DARK);
				
				//create the extent report
				 report=new ExtentReports();
				
				//configure extent report//
				report.setSystemInfo("Os", "window-11");
				report.setSystemInfo("Browser", "Chrome-100");
				
				//Attach extent report to spark
				
				report.attachReporter(spark);
				 	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	}

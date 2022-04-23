package Api_Testing;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener{
	ExtentReports extent;
	
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
			
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS," Test Case Passed" +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.FAIL," Test Case Failed" +result.getName());
		test.log(Status.FAIL," Test Case Failed" +result.getThrowable());
	}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.SKIP," Test Case Passed" +result.getName());
	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Api-Testing");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester","Anu");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}

}

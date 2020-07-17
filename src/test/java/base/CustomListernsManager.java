package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class CustomListernsManager extends MainBaseClass implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("*** Test Suite " + arg0.getName() + " started ***");
		extentReport.flush();
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		MainBaseClass.extentTest.log(Status.PASS, arg0.getTestName()+"PASS");
		MainBaseClass.extentTest.fail(arg0.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		MainBaseClass.extentTest.log(Status.PASS, arg0.getTestName()+"PASS");
		MainBaseClass.extentTest.skip(arg0.getThrowable());
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		extentReport.createTest(arg0.getTestName());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		MainBaseClass.extentTest.log(Status.PASS, arg0.getTestName()+"PASS");		
				
	}

}

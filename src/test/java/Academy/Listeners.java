package Academy;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Base;


public class Listeners implements ITestListener {
	
	Base b = new Base();

	public void onStart(ISuite arg0) {

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished
	public void onFinish(ISuite arg0) {

	}

	// This belongs to ITestListener and will execute before starting of Test
	public void onStart(ITestContext arg0) {

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is
	public void onFinish(ITestContext arg0) {

	}

	// This belongs to ITestListener and will execute only when the test is pass
	public void onTestSuccess(ITestResult arg0) {

	}

	// This belongs to ITestListener and will execute only on the event of fail test
	public void onTestFailure(ITestResult result) {
		
		 // to get test name
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This belongs to ITestListener and will execute before the main test start
	public void onTestStart(ITestResult arg0) {

	}

	// This belongs to ITestListener and will execute only if any of the main
	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

}

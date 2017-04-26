package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Liteners implements ITestListener {
	
	private static ExtentReports extent = ExtentManager.createInstance("extent.html");
	private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
        test.set(child);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		((ExtentTest) test.get()).pass("Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		((ExtentTest) test.get()).fail(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		((ExtentTest) test.get()).skip(result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	

}

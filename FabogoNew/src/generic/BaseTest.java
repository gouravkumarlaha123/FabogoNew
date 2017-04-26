package generic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class BaseTest implements ProgConst{
	
	public WebDriver driver;
	private static ExtentReports extent;
	public static ExtentTest logger;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
    
    @BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}
    
    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }
    
    public void openApp(){		
		System.setProperty(CHROME_VALUE, CHROME_KEY);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		logger.log(Status.INFO, "Browser Launched");
	
	}
    

	@BeforeMethod 
	 public synchronized void beforeMethod(Method method) {
        ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
        test.set(child);
	}
	
	@AfterMethod
	
	 public synchronized void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE)
	            ((ExtentTest) test.get()).fail(result.getThrowable());
	        else if (result.getStatus() == ITestResult.SKIP)
	            ((ExtentTest) test.get()).skip(result.getThrowable());
	        else
	            ((ExtentTest) test.get()).pass("Test passed");

	        extent.flush();
	    }
	 public void checkFail(ITestResult r) throws IOException{
			if(r.getStatus()==2){
			String screenShot=Photo.getScreenShot(driver,IMG_PATH);
			logger.fail("Test case failed");
			logger.addScreenCaptureFromPath(screenShot);
				
			}
			
		}
	 @AfterClass
	 public void tearDown(ITestResult r) {
			
			driver.quit();				
			logger.log(Status.INFO, "Browser Closed");
			extent.flush();
			
		}
	 @AfterSuite
	 
	 public void afterSuite() {
		 driver.get("file:///C:/Users/Administrator/git/FabogoNew123/FabogoNew/extent.html");
			
		}
	 

}

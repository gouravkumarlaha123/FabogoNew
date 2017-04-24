package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements ProgConst{
	
	public WebDriver driver;
	@BeforeMethod 
	public void openApp(){
		System.setProperty(CHROME_VALUE, CHROME_KEY);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
	@AfterMethod
	public void closeApp(ITestResult r){
		if(r.getStatus()==2){
			Photo.getScreenShot(driver,IMG_PATH);
			
		}
		driver.quit();
	}

}

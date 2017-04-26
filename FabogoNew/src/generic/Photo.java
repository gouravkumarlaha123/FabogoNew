package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo {
	
	public static String getScreenShot(WebDriver driver, String folderPath){
		
		SimpleDateFormat s=new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
		
		String dateTime=s.format(new Date());
		String screenshot_path =folderPath+dateTime+".png";
		TakesScreenshot t=(TakesScreenshot) driver;
		File srcFile=t.getScreenshotAs(OutputType.FILE);		
		File destFile=new File(screenshot_path);
		try{
			FileUtils.copyFile(srcFile, destFile);
		  
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}	
		return screenshot_path;
	}
}

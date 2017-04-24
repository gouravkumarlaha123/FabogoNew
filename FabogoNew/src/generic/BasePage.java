package generic;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void verifyElementIsPresent(WebElement element){
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is Present", true);
		}catch (Exception e) {
			Reporter.log("Element is not Present");
			Assert.fail();
		}
	}
		public void verifyTitle(String etitle){
			try{
				wait.until(ExpectedConditions.titleIs(etitle));
				Reporter.log("Title is Same",true);
			}catch (Exception e) {
				Reporter.log("Title is not Same ");
				Assert.fail();
			}
			
		}
	}




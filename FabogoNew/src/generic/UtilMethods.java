package generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UtilMethods {
	
	/*Allows to click on any WebElement*/
	public static void javascriptClickElement(WebDriver driver,String locatorValue,String locatorType){
		 WebElement element=null;
		
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
		
	/*Allows to Type on any Text box WebElement*/
	public static void javascriptType(WebDriver driver, String locatorValue,String locatorType, String value){
		 WebElement element=null;
			
			if(locatorType.equals("id")){
				element=driver.findElement(By.id(locatorValue));
			}
			else if(locatorType.equals("name")){
				element=driver.findElement(By.name(locatorValue));
			}
			else if(locatorType.equals("linkText")){
				element=driver.findElement(By.linkText(locatorValue));
			}
			else if(locatorType.equals("className")){
				element=driver.findElement(By.className(locatorValue));
			}
			else if(locatorType.equals("xpath")){
				element=driver.findElement(By.xpath(locatorValue));
			}
			else if(locatorType.equals("cssSelector")){
				element=driver.findElement(By.cssSelector(locatorValue));
			}
			else if(locatorType.equals("tagName")){
				element=driver.findElement(By.tagName(locatorValue));
			}
			else if(locatorType.equals("partialLinkText")){
				element=driver.findElement(By.partialLinkText(locatorValue));
			}
			else{
				System.out.println("Wrong locator type");
			}
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"'",element);
	}
	
	/*Allows to scroll horizontally and vertically  */
	public static void javascriptScrollWindow(WebDriver driver, int xScroll, int yScroll){
		((JavascriptExecutor)driver).executeScript("window.scrollTo("+xScroll+","+yScroll+")");
	}
	
	/*Verify the text present in the web page*/
	public static void verifyTextPresent(String expectedText,String locatorValue,String locatorType, WebDriver driver){
		 WebElement element=null;
			
			if(locatorType.equals("id")){
				element=driver.findElement(By.id(locatorValue));
			}
			else if(locatorType.equals("name")){
				element=driver.findElement(By.name(locatorValue));
			}
			else if(locatorType.equals("linkText")){
				element=driver.findElement(By.linkText(locatorValue));
			}
			else if(locatorType.equals("className")){
				element=driver.findElement(By.className(locatorValue));
			}
			else if(locatorType.equals("xpath")){
				element=driver.findElement(By.xpath(locatorValue));
			}
			else if(locatorType.equals("cssSelector")){
				element=driver.findElement(By.cssSelector(locatorValue));
			}
			else if(locatorType.equals("tagName")){
				element=driver.findElement(By.tagName(locatorValue));
			}
			else if(locatorType.equals("partialLinkText")){
				element=driver.findElement(By.partialLinkText(locatorValue));
			}
			else{
				System.out.println("Wrong locator type");
			}
		Assert.assertEquals(element.getText(), expectedText);
	}
	
	
	/*Verify if the Element is displayed*/
	public static void verifyElementDisplayed(String locatorValue,String locatorType, WebDriver driver){
		WebElement element=null;
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		Assert.assertEquals(element.isDisplayed(), true);
	}
	
	/*Verify the page URL*/
	public static void verifyPageUrl(WebDriver driver, String expectedUrl){
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}
	
	/*Get the hex for the element*/
	public static String getElementColorAsHex(String locatorValue,String locatorType, WebDriver driver){
		
		return getElementColorAsHex(locatorValue, locatorType, driver);
	}
	
	/*Select an item from List box by visible text*/
	
	public static void listBoxByVisibleText(String item,String locatorValue,String locatorType, WebDriver driver){
		WebElement element=null;
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		Select select=new Select(element);
		select.selectByVisibleText(item);		
	}
	
	/*Select an item from List box by index*/
	public static void listBoxByVisibleIndex(int index,String locatorValue,String locatorType, WebDriver driver){
		WebElement element=null;
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		Select select=new Select(element);
		select.selectByIndex(index);		
	}
	
	/*Select an item from List box by value*/
	public static void listBoxByValue(String value,String locatorValue,String locatorType, WebDriver driver){
		WebElement element=null;
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		Select select=new Select(element);		
		select.selectByValue(value);		
	}
	
	/*Select an item from Auto Suggestion after entering the search keyword in search text box*/
	public void autoSuggest(WebDriver driver, String text,String locator,String locatorVal){
		
		
		int count=0;
		List<WebElement> elements = null;
		if(locator.equals("id")){
			elements=driver.findElements(By.id(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("name")){
			elements=driver.findElements(By.name(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("linkText")){
			elements=driver.findElements(By.linkText(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("className")){
			elements=driver.findElements(By.className(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("xpath")){
			elements=driver.findElements(By.xpath(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("cssSelector")){
			elements=driver.findElements(By.cssSelector(locatorVal));
			count=elements.size();
		}
		else if(locator.equals("tagName")){
			elements=driver.findElements(By.tagName(locatorVal));
		}
		else if(locator.equals("partialLinkText")){
			elements=driver.findElements(By.partialLinkText(locatorVal));
			count=elements.size();
		}
		else{
			System.out.println("Wrong locator type");
			
		}
		int position=0;
		for(int i=0;i<count;i++)
		{
		WebElement aut = elements.get(i);
		String text1=aut.getText();
		System.out.println(text1);
		if(text.equals("selenium"))
		{
		position=i;
		}
		}
		elements.get(position).click();	
		
	}
}

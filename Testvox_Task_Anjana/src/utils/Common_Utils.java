package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Automation_base;

public class Common_Utils {

	Extractor extract=new Extractor();
	public void WindowMaximize() {
		Automation_base.driver.manage().window().maximize();
		
	}
	
	public String GettingText(WebDriver driver,String element)
	{
		return extract.extract_locator(driver, element).getText();
	}
	public void dropdown(WebDriver driver,String element,String option)
	{
	Select drop=new Select(extract.extract_locator(driver, element));
	drop.selectByVisibleText(option);
	}
	
	public void SwitchToFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	public void SwitchToParentFrame(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	public void Scrolldown(WebDriver driver,int value) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,"+value+")");
		
	}
	public void KeyboardEnterAction(WebDriver driver,String element) 
	{
	extract.extract_locator(driver, element).sendKeys(Keys.ENTER);
		
	}
	public void ScrollUp(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");
	}
	public void waitUsingXpath(WebDriver driver,String element,int second) {
		WebDriverWait wait=new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	public void waitUsingXpath_clickable(WebDriver driver,String element,int second) {
		WebDriverWait wait=new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
	}
	public void isdisplayed(WebDriver driver,String element)
	{
		extract.extract_locator(driver, element).isDisplayed();
	}
	public boolean isSelected(WebDriver driver,String element)
	{
		return extract.extract_locator(driver, element).isSelected();
	}
	public void Explicitwait(WebDriver driver,int second)
	{
		driver.manage().timeouts().pageLoadTimeout(second, TimeUnit.SECONDS);
	}
	public int GettingSizeOfElement(WebDriver driver,String element )
	{
	return driver.findElements(By.xpath(element)).size();
	}
}

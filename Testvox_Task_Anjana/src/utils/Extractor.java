package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Extractor {
WebElement element1;

public WebElement extract_locator(WebDriver driver,String element)
{
	if(element.startsWith("name>>"))
	        {
		element1=driver.findElement(By.name(element.substring(6)));
	        }
	if(element.startsWith("id>>"))
			{
		element1=driver.findElement(By.id(element.substring(4)));
			}
	if(element.startsWith("xpath>>"))
	{
element1=driver.findElement(By.xpath(element.substring(7)));
	}
	if(element.startsWith("link>>"))
	{
element1=driver.findElement(By.linkText(element.substring(6)));
	}
	return element1;
	
}
}

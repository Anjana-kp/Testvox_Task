package utils;

import org.openqa.selenium.WebDriver;

public class TypeAction {
Extractor extract=new Extractor();
	public void type(WebDriver driver,String element,String input)
	{
		extract.extract_locator(driver, element).sendKeys(input);
	}
	
	
	
}

package utils;

import org.openqa.selenium.WebDriver;

public class ClickAction {
	
	public void click(WebDriver driver,String element) {
Extractor extract=new Extractor();
extract.extract_locator(driver, element).click();
}
}
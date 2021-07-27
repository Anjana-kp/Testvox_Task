package config;

import org.testng.annotations.Test;

import base.Automation_base;
import object_Repo.ObjectRepository;
import utils.ClickAction;
import utils.Common_Utils;
import utils.Extractor;
import utils.TypeAction;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class Scenario1_Testcase {
	ClickAction click=new ClickAction();
	TypeAction type=new TypeAction();
	ObjectRepository object=new ObjectRepository();
	Common_Utils com=new Common_Utils();
	Extractor extract=new Extractor();
 
  @Test
  public void Scenario() throws Exception {
	  com.Scrolldown(Automation_base.driver,500);
	  click.click(Automation_base.driver, object.seemore_link);
	  Thread.sleep(3000);
	  String title=Automation_base.driver.getTitle();
	  assertEquals(title, "Amazon.com : amazonbasics");
	  String result=com.GettingText(Automation_base.driver, object.result);
	  System.out.println(result);
	  com.isdisplayed(Automation_base.driver, object.result);
	  com.Explicitwait(Automation_base.driver, 20);
	  com.Scrolldown(Automation_base.driver,1000);
	  click.click(Automation_base.driver, object.ourBrand);
	//  boolean isSelected=com.isSelected(Automation_base.driver, object.ourBrand);
	  com.Explicitwait(Automation_base.driver, 10);
	//  com.Scrolldown(Automation_base.driver,500);
	 // assertEquals(com.isSelected(Automation_base.driver, object.ourBrand), true);
	  List<WebElement>items=Automation_base.driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small']//h2 "));
	  List<String>itemsToString=new ArrayList<String>();
	  for(WebElement temp:items) {
		  itemsToString.add(temp.getText());
	  }
	 // com.Scrolldown(Automation_base.driver,200);
	  Thread.sleep(3000);
	  com.Scrolldown(Automation_base.driver,1000);
	  String nextButtonClassName=extract.extract_locator(Automation_base.driver, object.nextButton).getAttribute("class");
	  while(!nextButtonClassName.contains("last"))
	  {
		  click.click(Automation_base.driver, object.nextButton);
		  items=Automation_base.driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small']//h2 "));
		  for(WebElement temp:items) {
			  itemsToString.add(temp.getText());
			  if(itemsToString.contains("Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon"))
			  {
				 temp.click(); 
			  }
			
		  }
		  nextButtonClassName=extract.extract_locator(Automation_base.driver, object.nextButton).getAttribute("class");
	  
	  }
	  
	  for(String item:itemsToString)
	  {
	
		//  System.out.println(item);
	  }
	
	  String productTitle=Automation_base.driver.getTitle();
	  assertEquals(productTitle, "Amazon.com : Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon : Electronics");
	  assertEquals(com.isSelected(Automation_base.driver, object.size), true); 
	  click.click(Automation_base.driver, object.Addcart);	
	  assertEquals(com.GettingText(Automation_base.driver, object.cartMessage), "Added to Cart");
	  assertEquals(com.GettingText(Automation_base.driver, object.itemcount), "Proceed to checkout (1 item)");
  }
 
	
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  Automation_base.initialisation();
	  
  }

  @AfterMethod
  public void afterMethod() {
	// Automation_base.quit();
  }

}

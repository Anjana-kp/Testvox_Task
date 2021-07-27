package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Common_Utils;

public class Automation_base {
public static WebDriver driver;
public static Properties prop;

public static void initialisation() throws Exception {
	prop=new Properties();
	
	FileInputStream file=new FileInputStream("./config.properties");
	prop.load(file);
	if(prop.getProperty("driver").contentEquals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver1.exe");
		driver=new ChromeDriver();
	}
	else if(prop.getProperty("driver").contentEquals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", " ");
		driver=new FirefoxDriver();
	}
	//driver.get(url);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
}

public static void quit() {
	driver.quit();
}
}

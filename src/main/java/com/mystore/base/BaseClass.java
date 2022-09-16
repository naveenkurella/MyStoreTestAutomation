package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static Properties prop;
//	public static  WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	
	@BeforeSuite(groups= {"Regression","Sanity","Smoke"})
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	prop=new Properties();
		
		try {
			FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	

public static void launhcApp(String browserName) {
	
	
	if (browserName.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		// Set Browser to ThreadLocalMap
		driver.set(new ChromeDriver());
	} else if (browserName.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver.set(new FirefoxDriver());
	} else if (browserName.equalsIgnoreCase("IE")) {
		WebDriverManager.iedriver().setup();
		driver.set(new InternetExplorerDriver());
	}

	
	Action.implicitWait(getDriver(),15);
	Action.pageLoadTimeOut(getDriver(), 30);
	Action.launchUrl(getDriver(), prop.getProperty("url"));

}

@AfterSuite
public void afterSuite() {
	ExtentManager.endReport();
}

}

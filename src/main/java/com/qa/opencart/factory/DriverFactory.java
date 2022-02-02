package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
public	WebDriver driver;
public static String highlight;
	

public WebDriver initDriver(Properties prop) 
	
	{
		String BrowserName=prop.getProperty("browser");
		System.out.println("Browser Name:" +BrowserName);
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("safari"))
		{
			
			driver = new SafariDriver();
			
		}
		else
		{
			System.out.println("please enter correct browser name "+BrowserName );
			}
		
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	//driver.wait(2000);
	driver.get(prop.getProperty("url"));
	return driver;
	}
	/* This method is used to initialize config.properties file*/

	public Properties initProperties()  	{
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			 prop = new Properties();
			prop.load(ip);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
}


package com.qa.democart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
public	WebDriver driver;

	public void manag()
	{
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	
		driver.get("https://mail.google.com/mail/u/0/#inbox");
//		WebElement dynamicElement= (new WebDriverWait(driver,21)).until(ExpectedConditions.presenceOfElementLocated(By.id("")))
	}
	
	

}

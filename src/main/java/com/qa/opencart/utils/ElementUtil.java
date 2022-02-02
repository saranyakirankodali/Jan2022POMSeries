package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	public List<WebElement> getElements(By locator)
	{
		List<WebElement> element = driver.findElements(locator);
		return element;
	}
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public void doSendKeys(By locator,String value)
	{
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public String waitForTitleIs(String fullTitle,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleIs(fullTitle))) {
			return driver.getTitle();
		}
		return null;
	}
	public String doGetText(By locator) {
		
		return driver.findElement(locator).getText();
	}
		
	}


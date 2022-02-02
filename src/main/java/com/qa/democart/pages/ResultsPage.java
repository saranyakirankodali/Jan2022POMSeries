package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
public WebDriver driver;
private ElementUtil elementUtil;
private By searchHeader = By.cssSelector("div#content h1");
private By productsResults = By.cssSelector("div.caption a");
 
public ResultsPage(WebDriver driver)
{
	this.driver = driver;
	elementUtil = new ElementUtil(driver);
}

public String getSearchPageHeader()
{
	return elementUtil.doGetText(searchHeader);	
}
 
public int getProductSearchListsCount()
{
	return elementUtil.getElements(productsResults).size();
}
public ProductInfoPage selectProduct(String mainProductName)
{
	List<WebElement>searchList=elementUtil.getElements(productsResults);
	
	for(WebElement e: searchList)
	{
		if(e.getText().trim().equals(mainProductName))
		{
			e.click();
			break;
		}
	}
	return new ProductInfoPage(driver);
}




}

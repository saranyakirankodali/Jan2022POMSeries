package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By header = By.cssSelector("div#logo h1 a "); 
	private By accSections = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Address Book");
	private By searchField = By.xpath("//div [@class ='input-group']//input");
	private By searchButton = By.xpath("//div [@class ='input-group']//button[@class='btn btn-default btn-lg']");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public String getAccountPageTItle()
	{
		return elementUtil.waitForTitleIs(Constants.HEADER_PAGE_TITLE,5);
	}
	
	/*public String getAccountPageURL()
	{
		return elementUtil.waitForFullUrl(Constants.HEADER_PAGE_URL,5);
	}*/
	public String getAccountPageHeader()
	{
		return elementUtil.doGetText(header);
	}
	public List<String> getAccountSectionList()
	{
   List<String>	AccSecValueList = new ArrayList<String>();
       List<WebElement> AccSecList = elementUtil.getElements(accSections);
		
		for(WebElement e: AccSecList)
		{
			AccSecValueList.add(e.getText());
		}
		Collections.sort(AccSecValueList);
		return AccSecValueList;
	}
	public List<String> getAccSecList()
	{
		List<String>accountSecValueList=new ArrayList<String>();
			List<WebElement> accountSecList = elementUtil.getElements(accSections);
		for(WebElement e: accountSecList)
		{
			accountSecValueList.add(e.getText());
		}
		System.out.println("Printing all test cases here");
		return accountSecValueList;
	}
	
	
	public boolean isLogoutLinkExists()
	{
	return	elementUtil.doIsDisplayed(logoutLink);
	}
	
	public ResultsPage doSearch(String productname)
	{
		System.out.println("Search product is:"+productname);
		elementUtil.doSendKeys(searchField, productname);
		elementUtil.doClick(searchButton);
		return new ResultsPage(driver);
	}
}
	


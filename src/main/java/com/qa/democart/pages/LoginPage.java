package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
    
	private WebDriver driver;
	private ElementUtil elementUtil;
	//private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgetPwd = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By header = By.xpath("//div [@class='col-sm-4'] //a [text() ='Your Store']");
  
	//constructor
	public LoginPage(WebDriver driver)
  {
	 this.driver = driver;
	 elementUtil = new ElementUtil(driver);
	 
  }
  //page actions
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
  public String getPageHeaderText()
  {
	  return  driver.findElement(header).getText();
	    }
  public boolean isForgetPwdLinkExist()
  {
	  return driver.findElement(forgetPwd).isDisplayed();
  }
  
  public AccountsPage doLogin(String un,String pwd) 
  {
	  elementUtil.doSendKeys(emailId,un);
	  elementUtil.doSendKeys(password,pwd);
	  elementUtil.doClick(loginBtn);
	 // Thread.sleep(2000);
	  return new AccountsPage(driver);
  }

}
















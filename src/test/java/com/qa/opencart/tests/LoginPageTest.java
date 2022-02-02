package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.opencart.utils.ApplicationErrors;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title =loginpage.getLoginPageTitle();
		System.out.println("Login Page title:" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,ApplicationErrors.LOGIN_PAGE_TITLE );
		
	}
	
	@Test(priority=2)
	public void loginPageHeaderTest()
	{
	
	 String header = loginpage.getPageHeaderText();
	 System.out.println("login page header:" +header);
	 Assert.assertEquals(header,Constants.PAGE_HEADER, ApplicationErrors.PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void forgetPwdLinkTest()
	{
		Assert.assertTrue(loginpage.isForgetPwdLinkExist());
	}
	@Test(priority=4)
	public void loginTest() throws InterruptedException
	{
  AccountsPage accPage=	loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}
	
	
	
	
	
}

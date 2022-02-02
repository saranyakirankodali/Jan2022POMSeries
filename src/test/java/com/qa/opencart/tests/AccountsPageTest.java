package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	
	@BeforeClass
	public void accPageSetup()
	{
		accPage =	loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void accPageTitleTest()
	{
	String title=	accPage.getAccountPageTItle();
	System.out.println("Account Page Title"+title);
	Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void accPageHeaderTest()
	{
		String header = accPage.getAccountPageHeader();
		System.out.println("Account page Header:"+header);

		Assert.assertEquals(header, Constants.PAGE_HEADER);
	}

	@Test(priority=3)
	public void accSectionsListTest()
	{
		List<String> actAccSecList = accPage.getAccSecList();
		System.out.println("actual sections:"+actAccSecList);
		Assert.assertEquals(actAccSecList, Constants.EXPECTED_ACC_SEC_LIST);
	}
	@DataProvider (name = "searchData")
	public Object[][] getSearchData()
	{
		return new Object[][] {
			{"Macbook Pro"},
			{"Macbook"},
			{"Apple"}
			};
		
		
	}
	@Test(priority=5 , dataProvider="searchData")
	public void searchTest(String productName)
	{
		resultsPage=accPage.doSearch(productName);
	String resultHeader=	resultsPage.getSearchPageHeader();
		System.out.println(resultHeader);
		Assert.assertTrue(resultHeader.contains(productName));
	}
	
	@Test(priority = 4)
	public void logOutLinkExistTest()
	{
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}
	
	@DataProvider
	public Object [][] getProductSelectData(){
		return new Object[][] {
		{"Macbook","MacBook Pro"},
		{"Macbook", "MacBook"},
		{"Apple","Apple Cinema 30\""}
		};
	}
	
	@Test(priority =6, dataProvider = "getProductSelectData")
	public void selectProductTest(String productName,String mainProductName)
	{
	resultsPage=	accPage.doSearch(productName);
	productinfoPage=resultsPage.selectProduct(mainProductName);
    String header=	productinfoPage.getProductHeaderTitle();
    System.out.println("product header:" +header);
    Assert.assertEquals(header, mainProductName);
    
	}
	


}

package com.qa.democart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementutil;
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails a");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
    private By productPriceData =  By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
    private Map <String,String>productInfoMap;
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}
	public String getProductHeaderTitle()
	{
		return elementutil.doGetText(productHeader);
	}
	
	public int getImagesCount()
	{
		return elementutil.getElements(productImages).size();
	}

	public Map<String, String> getProductInfo()
	{
		productInfoMap = new HashMap<String,String>();
		productInfoMap.put("name", getProductHeaderTitle());
		
		List<WebElement>metaDataList=elementutil.getElements(productMetaData);
		
		for(WebElement e: metaDataList)
		{
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
			
		}
		
		
		//price data
		List<WebElement> priceList = elementutil.getElements(productPriceData);
		System.out.println("Total product price list:"+priceList.size());
		
		String price = priceList.get(0).getText().trim();
		String exTaxPrice = priceList.get(1).getText().trim();
		productInfoMap.put("price",price);
		productInfoMap.put("exTaxPrice", exTaxPrice);
		
		
		return productInfoMap;
	}
}

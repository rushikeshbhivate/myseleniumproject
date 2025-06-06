package com.ERP.PageObjects;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.NestingKind;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OE_InfoPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;

	public OE_InfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//input[@id=\"product_group_id\"]")
	WebElement ProductGroup;
	
	@FindBy(xpath = "//ul[@id=\"ui-id-7\"]//li")
	List<WebElement> productGroupList;
	
	public void productGroup(String Value)
	{
		ProductGroup.click();
		
		boolean Found = false;
		
		for(WebElement Option: productGroupList)
		{
			if(Option.getText().trim().equalsIgnoreCase(Value))
			{
				try {
					executor.executeScript("arguments[0].click();", Option);
					Found = true;
					break;
					
				} catch (Exception e) {
					
					System.out.println("Exception while clicking: " + e.getMessage());
				}	
			}
		}
		
		if(!Found){
			throw new RuntimeException("Value '" + Value + "' Not found or could not be clickable");
		}
	}
	
	@FindBy(xpath = "//textarea[@name=\"catalog_comments\"]")
	WebElement CatalogComments;
	
	public void catalogComments(String Value)
	{
		CatalogComments.sendKeys(Value);
	}
	
	@FindBy(xpath = "//input[@value=\"Product Review\"]")
	WebElement ProductReview;
	
	public void productReview()
	{
		ProductReview.click();
	}
}

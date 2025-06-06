package com.ERP.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	WebDriver driver;
	JavascriptExecutor executor;

	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
	}

	@FindBy(xpath = "//a[text()=\"RFQs\"]")
	WebElement RFQs;

	public void rfq()
	{
		RFQs.click();
	}

	@FindBy(xpath = "//a[@href=\"new-rfq\"]")
	WebElement NewRFQ;

	public void newRFQ()
	{
		NewRFQ.click();
	}

	@FindBy(xpath = "//a[text()=\"New OE Number \"]")
	WebElement NewOENumber;
	
	public void newOENumber()
	{
		NewOENumber.click();
	}
	
	@FindBy(xpath = "//a[@href=\"oe-info\"]")
	WebElement OEInfo;
	
	public void oeInfo()
	{
		OEInfo.click();
	}
	
	@FindBy(xpath = "//a[@href=\"oe-product\"]")
	WebElement Product;
	
	public void product()
	{
		Product.click();
	}
}

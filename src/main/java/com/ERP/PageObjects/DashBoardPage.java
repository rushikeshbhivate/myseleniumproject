package com.ERP.PageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;


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

}

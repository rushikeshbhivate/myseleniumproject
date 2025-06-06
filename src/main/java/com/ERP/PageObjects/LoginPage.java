package com.ERP.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	JavascriptExecutor executor;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"j_username\"]")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id=\"j_password\"]")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id=\"login\"]")
	WebElement Login;
	
	public void username(String Name)
	{
		Username.sendKeys(Name);
	}
	
	public void password(String pass)
	{
		Password.sendKeys(pass);
	}

	public void login()
	{
		Login.click();
	}
}

package com.ERP.TestCases;

import org.testng.annotations.Test;

import com.ERP.PageObjects.LoginPage;
import com.ERP.Utilities.BaseClass;

public class TC_VerifyLogin extends BaseClass{
	
	@Test
	public void verifyLogin()
	{
		LoginPage login = new LoginPage(driver);
		login.username("testuser@premiumguard.com");
		login.password("Anveshak");
		login.login();
	}

}

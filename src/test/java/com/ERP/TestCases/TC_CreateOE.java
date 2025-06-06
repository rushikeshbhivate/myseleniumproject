package com.ERP.TestCases;

import org.testng.annotations.Test;

import com.ERP.PageObjects.DashBoardPage;
import com.ERP.PageObjects.NewRFQPage;
import com.ERP.PageObjects.OE_InfoPage;
import com.ERP.Utilities.BaseClass;
import com.github.javafaker.Faker;

public class TC_CreateOE extends BaseClass{

	Faker faker = new Faker();
	
	@Test
	public void createNewOE()
	{
		TC_VerifyLogin login = new TC_VerifyLogin();
		login.verifyLogin();
		
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.newOENumber();
		dashboard.oeInfo();
		
		NewRFQPage newRFQPage = new NewRFQPage(driver);
		newRFQPage.rfqReason("Supply Chain");
		newRFQPage.oe(faker);
		newRFQPage.primaryMake("Hyundai");
		newRFQPage.model("Elantra");
		newRFQPage.subModel("1.8L");
		newRFQPage.minYear("2009");
		newRFQPage.maxYear("2022");
		newRFQPage.usaOnlyCheckbox();
		
		OE_InfoPage OEInfo = new OE_InfoPage(driver);
		OEInfo.productGroup("Fuel Cap");
		OEInfo.productReview();
		dashboard.product();
		
	}
}

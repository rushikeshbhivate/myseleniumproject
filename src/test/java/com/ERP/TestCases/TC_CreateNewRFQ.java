package com.ERP.TestCases;

import org.testng.annotations.Test;

import com.ERP.PageObjects.DashBoardPage;
import com.ERP.PageObjects.NewRFQPage;
import com.ERP.Utilities.BaseClass;
import com.github.javafaker.Faker;

public class TC_CreateNewRFQ extends BaseClass{
	
	Faker faker = new Faker();
	@Test
	public void createNewRFQ()
	{
		TC_VerifyLogin login = new TC_VerifyLogin();
		login.verifyLogin();
		
		DashBoardPage DashBoard = new DashBoardPage(driver);
		DashBoard.rfq();
		DashBoard.newRFQ();
		
		NewRFQPage newRfq = new NewRFQPage(driver);
		newRfq.rfqReason("Supply Chain");
		newRfq.oe(faker);
		newRfq.closeDate();
		newRfq.description("Test");
		newRfq.primaryMake("Cadillac");
		newRfq.model("CT5");
		newRfq.subModel("3.0L");
		newRfq.minYear("2008");
		newRfq.maxYear("2022");
		newRfq.usaOnlyCheckbox();
		newRfq.productGroup("Oil Filter");
		newRfq.stockingDecision("Stockable");
		newRfq.style("Cartridge filter");
		newRfq.initialOrderQty("10");
		newRfq.media("Standard");
		newRfq .qtyCase("2");
		newRfq.save();
		newRfq.wantSystemAssignedBaseNumber();
		newRfq.saveRFQ();
		newRfq.sendRFQ();
		newRfq.selectSupplier();
		newRfq.sendRFQ2();
	}

}

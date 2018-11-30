package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.OffersPage;
import com.travels.qa.utility.Testutility;

public class Offers_Testcase extends TestBase {
	
	HomePage homepage;
	Testutility utility;
	OffersPage offers;
	
	public Offers_Testcase() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		offers= new OffersPage();
	}
	
	//Verifying whether the content is readable or not TC #1
	@Test
	public void Offer_reading() {
	test=extent.createTest("Offer_reading");
	homepage.OffersButtonClick();	
	boolean elementdisplay=offers.readmore_button();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying whether an offer is accepted by a user or not TC #2
	@Test
	public void Offer_acceptance() {
	test=extent.createTest("Offer_acceptance");
	homepage.OffersButtonClick();
	boolean elementdisplay=offers.Applying_for_offer();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

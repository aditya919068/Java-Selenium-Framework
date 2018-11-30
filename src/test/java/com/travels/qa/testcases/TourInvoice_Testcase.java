package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.AccountPage;
import com.travels.qa.pages.ConfirmationPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.InvoicePage;
import com.travels.qa.pages.SignUpPage;
import com.travels.qa.pages.TourBookingPage;
import com.travels.qa.pages.TourPage;
import com.travels.qa.utility.Testutility;

public class TourInvoice_Testcase extends TestBase{
	
	HomePage homepage;
	Testutility utility;
	TestWait wait;
	TourPage tour;
	TourBookingPage tourbooking;
	ConfirmationPage confirmation;
	InvoicePage invoice;
	AccountPage account;
	SignUpPage signup;
	
	public TourInvoice_Testcase() {
		super();
	}

	@BeforeMethod
	public void setup() {
	initialization();
	homepage = new HomePage();
	utility = new Testutility();
	wait= new TestWait();
	tour=new TourPage();
	tourbooking=new TourBookingPage();
	confirmation=new ConfirmationPage();
	invoice= new InvoicePage();
	account=new AccountPage();
	signup=new SignUpPage();
	}
	
	//Making a payment on arrival as a guest TC #1
	@Test
	public void payement_on_arrival() {
	test=extent.createTest("payement_on_arrival");
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.tourbooking();
	confirmation.Confirmation_As_A_Guest();
	boolean textdisplay=invoice.payment_arrival();
	Assert.assertTrue(textdisplay);
	}

	//Making a payment now as a guest TC #2
	@Test
	public void payment_Now() {
	test=extent.createTest("payment_Now");
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.tourbooking();
	confirmation.Confirmation_As_A_Guest();
	invoice.payment_Now();
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "PayPal Checkout");
	}
	
	//Making sure that the invoice is displayed to the user TC #3
	@Test
	public void Invoice_Visibility() {
	test=extent.createTest("Invoice_Visibility");
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.tourbooking();
	confirmation.Confirmation_As_A_Guest();
	boolean textdisplay=invoice.Invoice_Visibility();
	Assert.assertTrue(textdisplay);
	}
	
	//Making a payment on arrival as a Signed Up user TC #4
	@Test
	public void payment_on_arrival_when_SignedUp() {
	test=extent.createTest("payment_on_arrival_when_SignedUp");
	homepage.Signup();
	signup.SignUp_Form();
	account.homescreen_navigate();
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.tourbooking();
	confirmation.Confirmation_As_A_Permanent_User();
	boolean textdisplay=invoice.payment_arrival();
	Assert.assertTrue(textdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}

}

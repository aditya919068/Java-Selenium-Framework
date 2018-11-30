package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.ConfirmationPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.TourBookingPage;
import com.travels.qa.pages.TourPage;
import com.travels.qa.utility.Testutility;

public class TourBooking_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	TestWait wait;
	TourPage tour;
	TourBookingPage tourbooking;
	ConfirmationPage confirmation;


	public TourBooking_Testcase() {
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
	}
	
	//Verifying that a Tour gets booked TC #1
	@Test
	public void booking_tour() {
	test=extent.createTest("booking_tour");
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.tourbooking();
	boolean elementdisplay=confirmation.confirmation_button();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying that date gets changed when booking a tour TC #2
	@Test
	public void Date_Change_Of_the_Tour() {
	test=extent.createTest("Date_Change_Of_the_Tour");
	homepage.TourBooking();
	tour.Tour_Booking();
	tourbooking.DateChange();;
	boolean elementdisplay=confirmation.confirmation_button();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}

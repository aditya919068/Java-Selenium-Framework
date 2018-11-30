package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.TourBookingPage;
import com.travels.qa.pages.TourPage;
import com.travels.qa.utility.Testutility;

public class Tour_Testcase extends TestBase {
	HomePage homepage;
	Testutility utility;
	TestWait wait;
	TourPage tour;
	TourBookingPage tourbooking;


	public Tour_Testcase() {
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
	}
	
	//Verifying User is navigated to the Tour booking page TC #1
	@Test
	public void Navigating_to_Tour_booking() {
	test=extent.createTest("Navigating_to_Tour_booking");
	homepage.TourBooking();
	tour.Tour_Booking();
	boolean elementdisplay=tourbooking.booknowbutton();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying Star filters the tour TC #2
	@Test
	public void Tour_Filter() {
	test=extent.createTest("Tour_Filter");
	homepage.TourBooking();
	boolean elementdisplay=tour.star_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying tour type radiobutton filters the cars TC #3
	@Test
	public void Cars_Radiobutton_Filter() {
	test=extent.createTest("Cars_Radiobutton_Filter");
	homepage.TourBooking();
	boolean elementdisplay=tour.tour_type_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}
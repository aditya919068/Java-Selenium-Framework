package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.CarsBookingPage;
import com.travels.qa.pages.CarsPage;
import com.travels.qa.pages.ConfirmationPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.utility.Testutility;

public class CarsBooking_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	TestWait wait;
	CarsPage cars;
	CarsBookingPage carsbooking;
	ConfirmationPage confirmation;


	public CarsBooking_Testcase() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		wait= new TestWait();
		cars=new CarsPage();
		carsbooking=new CarsBookingPage();
		confirmation=new ConfirmationPage();
	}
	
	//Verifying that a Car gets booked TC #1
	@Test
	public void booking_car() {
	test=extent.createTest("booking_car");
	homepage.CarBooking();
	cars.Cars_Booking();
	carsbooking.booking_car();
	boolean elementdisplay=confirmation.confirmation_button();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}
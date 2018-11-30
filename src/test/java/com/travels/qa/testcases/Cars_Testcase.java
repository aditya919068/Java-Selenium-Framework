package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.CarsBookingPage;
import com.travels.qa.pages.CarsPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.utility.Testutility;

public class Cars_Testcase extends TestBase {
	
	HomePage homepage;
	Testutility utility;
	TestWait wait;
	CarsPage cars;
	CarsBookingPage carsbooking;


	public Cars_Testcase() {
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
	}
	
	//Verifying User is navigated to the Cars booking page TC #1
	@Test
	public void Navigating_to_Cars_booking() {
	test=extent.createTest("Navigating_to_Cars_booking");
	homepage.CarBooking();
	cars.Cars_Booking();
	boolean elementdisplay=carsbooking.booknowbutton();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying Star filters the Cars TC #2
	@Test
	public void Cars_Filter() {
	test=extent.createTest("Cars_Filter");
	homepage.CarBooking();
	boolean elementdisplay=cars.star_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying Cars type CheckBoxes filters the cars TC #3
	@Test
	public void Cars_Checkbox_Filter() {
	test=extent.createTest("Cars_Checkbox_Filter");
	homepage.CarBooking();
	boolean elementdisplay=cars.cars_type_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}

}

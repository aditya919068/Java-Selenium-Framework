package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.HotelBookingPage;
import com.travels.qa.pages.HotelsPage;
import com.travels.qa.utility.Testutility;

public class Hotels_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	TestWait wait;
	HotelsPage hotels;
	HotelBookingPage hotelbooking;


	public Hotels_Testcase() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		wait= new TestWait();
		hotels= new HotelsPage(); 
		hotelbooking=new HotelBookingPage();
	}
	
	//Verifying User is navigated to the hotels booking page TC #1
	@Test
	public void Navigating_to_Hotel_booking() {
	test=extent.createTest("Navigating_to_Hotel_booking");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	boolean elementdisplay=hotelbooking.modifybutton();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying Star filters the hotels TC #2
	@Test
	public void Hotels_Filter() {
	test=extent.createTest("Hotels_Filter");
	homepage.Hotelbooking();
	boolean elementdisplay=hotels.star_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying property types CheckBoxes filters the hotels TC #3
	@Test
	public void Property_Checkbox_Filter() {
	test=extent.createTest("Property_Checkbox_Filter");
	homepage.Hotelbooking();
	boolean elementdisplay=hotels.property_type_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	//Verifying Amenities types CheckBoxes filters the hotels TC #4
	@Test
	public void Amenities_Checkbox_Filter() {
	test=extent.createTest("Amenities_Checkbox_Filter");
	homepage.Hotelbooking();
	boolean elementdisplay=hotels.Amenities_type_filter();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}

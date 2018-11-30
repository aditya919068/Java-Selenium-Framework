package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.HotelBookingPage;
import com.travels.qa.pages.ConfirmationPage;
import com.travels.qa.pages.HotelsPage;
import com.travels.qa.utility.Testutility;

public class HotelBooking_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	TestWait wait;
	HotelsPage hotels;
	HotelBookingPage hotelbooking;
	ConfirmationPage hotelconfirmation;

	public HotelBooking_Testcase() {
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
		hotelconfirmation= new ConfirmationPage();
	}
	
	//Making modification to the hotel booking details of the user TC #1
	@Test
	public void Booking_Modification() {
	test=extent.createTest("Booking_Modification");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();	
	hotelbooking.Updating_Hotel_Confirmation();
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "www.phptravels.net");
	}
	
	//Making selection of the rooms available TC #2
	@Test
	public void Room_Selection() {
	test=extent.createTest("Room_Selection");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	hotelbooking.Room_Type_Selection();
	boolean elementdisplay=hotelconfirmation.confirmation_button();
	Assert.assertTrue(elementdisplay);
	}
	
	//Clicking on the details button to get the info of the room TC #3
	@Test
	public void Room_Details() {
	test=extent.createTest("Room_Details");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	boolean elementdisplay=hotelbooking.details_button_click();
	Assert.assertTrue(elementdisplay);
	}
	
	//Clicking on the Availability button to get the info of the rooms available TC #4
	@Test
	public void RoomAvailability_Details() {
	test=extent.createTest("RoomAvailability_Details");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	boolean elementdisplay=hotelbooking.Check_Availability();
	Assert.assertTrue(elementdisplay);
	}
	
	//Clicking on the Write Review button to write a review for the room TC #5
	@Test
	public void Writing_Room_Review() {
	test=extent.createTest("Writing_Room_Review");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	boolean elementdisplay=hotelbooking.Room_review();
	Assert.assertTrue(elementdisplay);
	}
	
	//Adding hotel to wishlist when not logged in TC #6
	@Test
	public void Wishlisting_hotel() {
	test=extent.createTest("Wishlisting_hotel");
	homepage.Hotelbooking();
	hotels.Hotel_Booking();
	String messagedisplay=hotelbooking.WishList();
	Assert.assertEquals(messagedisplay, "Please Login to add to wishlist.");
	}
		
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}

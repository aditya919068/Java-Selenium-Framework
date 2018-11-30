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
import com.travels.qa.pages.InvoicePage;
import com.travels.qa.utility.Testutility;

public class CarsConfirmation_Testcase extends TestBase {
	HomePage homepage;
	Testutility utility;
	TestWait wait;
	CarsPage cars;
	CarsBookingPage carsbooking;
	ConfirmationPage confirmation;
	InvoicePage invoice;
	
	public CarsConfirmation_Testcase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		wait= new TestWait();
		confirmation= new ConfirmationPage();
		cars=new CarsPage();
		carsbooking=new CarsBookingPage();
		invoice= new InvoicePage();
	}
	
	//Making a booking as a guest TC #1
	@Test
	public void booking_as_a_guest() {
	test=extent.createTest("booking_as_a_guest");
	homepage.CarBooking();
	cars.Cars_Booking();
	carsbooking.booking_car();
	confirmation.Confirmation_As_A_Guest();
	boolean elementdisplay=invoice.printbutton();
	Assert.assertTrue(elementdisplay);
	}
	
	//Making a booking with an exsisting user but without proper username/password TC #2
	@Test
	public void book_with_invalid_user() {
	test=extent.createTest("book_with_invalid_user");
	homepage.CarBooking();
	cars.Cars_Booking();
	carsbooking.booking_car();
	boolean mesagedisplay=confirmation.Exsisting_user_with_invalid_Id_password();
	Assert.assertTrue(mesagedisplay);
	}
	
	//Writing a note while making an order TC #3
	@Test
	public void make_a_note_while_ordering() {
	test=extent.createTest("make_a_note_while_ordering");
	homepage.CarBooking();
	cars.Cars_Booking();
	carsbooking.booking_car();
	confirmation.Add_Message();
	confirmation.Confirmation_As_A_Guest();
	boolean elementdisplay=invoice.printbutton();
	Assert.assertTrue(elementdisplay);
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}

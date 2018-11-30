package com.travels.qa.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestLists;
import com.travels.qa.pages.CarsBookingPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.HotelBookingPage;
import com.travels.qa.pages.TourBookingPage;
import com.travels.qa.utility.Testutility;

public class HomePage_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	TestLists Lists;
	HotelBookingPage hotelbooking;
	CarsBookingPage carsbooking;
	TourBookingPage tourbooking;
	
	public HomePage_Testcase() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		Lists =new TestLists();
		hotelbooking=new HotelBookingPage();
		carsbooking=new CarsBookingPage();
		tourbooking=new TourBookingPage();
	}
	
	//Checking the text of the DropDown TC #1
	@Test
	public void Text_Of_The_DropDown() {
		test=extent.createTest("Text_Of_The_DropDown");
		String text=homepage.DropDownsText();
		Assert.assertEquals(text, "MY ACCOUNT");
	}
	
	//Clicking the SignUp TC #2
	@Test
	public void Success_Upon_Clicking_Signup_Link() {
		test=extent.createTest("Success_Upon_Clicking_Signup_Link");
		homepage.Signup();
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Register");
	}
	
	//Clicking the Login TC #3
	@Test
	public void Success_Upon_Clicking_Login_Link() {
		test=extent.createTest("Success_Upon_Clicking_Login_Link");
		homepage.Login();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Login");
	}
	
	//Checking Currency presence from actual to the expected TC #4
	@Test
	public void Checking_Presence_Of_Currency_In_The_List() {
		test=extent.createTest("Checking_Presence_Of_Currency_In_The_List");
		List<String> Expected_List_Of_the_DropDown=homepage.currency();
		List<String> Actual_List_Of_the_DropDown=Lists.Currency_Suggestions();
		Assert.assertEquals(Actual_List_Of_the_DropDown, Expected_List_Of_the_DropDown );
	}
	
	//Checking Language presence from actual to the expected TC #5
		@Test
		public void Checking_Presence_Of_Language_In_The_List() {
			test=extent.createTest("Checking_Presence_Of_Language_In_The_List");
			List<String> Expected_List_Of_the_DropDown=homepage.language();
			List<String> Actual_List_Of_the_DropDown=Lists.Language_Suggestions();
			Assert.assertEquals(Actual_List_Of_the_DropDown, Expected_List_Of_the_DropDown );
		}
		
	//Verifying presence of the Logo TC #6
		@Test
		public void Checking_Presence_Of_Logo() {
			test=extent.createTest("Checking_Presence_Of_Logo");
			boolean check_logo=homepage.FindLogo();
			Assert.assertTrue(check_logo);
		}
		
	//Verifying presence of the PhoneNumber TC #7
		@Test
		public void Checking_Presence_Of_PhoneNumber() {
			test=extent.createTest("Checking_Presence_Of_PhoneNumber");
			boolean check_Phone_Number=homepage.FindPhoneNumber();
			Assert.assertTrue(check_Phone_Number);
		}
		
	//Verifying presence of the Email Address TC #8
		@Test
		public void Checking_Presence_Of_Email_Address() {
			test=extent.createTest("Checking_Presence_Of_Email_Address");
			boolean check_Email_Address=homepage.FindEmailAddress();
			Assert.assertTrue(check_Email_Address);
		}
		
	//Verifying whether on Logo click the application lands on the HomeScreen again or not TC #9
		@Test
		public void Checking_Logo_Click_Helps_To_Land_On_HomeScreen() {
			test=extent.createTest("Checking_Logo_Click_Helps_To_Land_On_HomeScreen");
			String URL=homepage.LogoClick();
			Assert.assertEquals(URL, "https://www.phptravels.net/");
		}
				
    //Verifying whether on Clicking Home the application lands on the HomeScreen again or not TC #10
		@Test
		public void Checking_HomeButton_Click_Helps_To_Land_On_HomeScreen() {
			test=extent.createTest("Checking_HomeButton_Click_Helps_To_Land_On_HomeScreen");
			String URL=homepage.HomeButtonClick();
			Assert.assertEquals(URL, "https://www.phptravels.net/");
		}
	
    //Verifying whether the text of the Home Button matches with the expectations or not TC #11
		@Test
		public void Checking_the_Text_Of_the_Homebutton() {
			test=extent.createTest("Checking_the_Text_Of_the_Homebutton");
			String Text=homepage.HomeButtonText();
			Assert.assertEquals(Text, "HOME");
		}
	
	//Verifying that clicking on the BlogButton user shall navigate to the BlogPage TC #12
		@Test
		public void Clicking_the_BlogButton_Navigates_to_Blog_Page() {
		test=extent.createTest("Clicking_the_BlogButton_Navigates_to_Blog_Page");
		homepage.BlogButtonClick();
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.phptravels.net/blog");
		}
   
	//Verifying whether the text of the BlogButton matches with the expectations or not TC #13
		@Test
		public void Checking_the_Text_Of_the_Blogbutton() {
		test=extent.createTest("Checking_the_Text_Of_the_Blogbutton");
		String Text=homepage.BlogButtonText();
		Assert.assertEquals(Text, "BLOG");
		}

	//Verifying that clicking on the OffersButton user shall navigate to the OffersPage TC #14
		@Test
		public void Clicking_the_OffersButton_Navigates_to_Offers_Page() {
		test=extent.createTest("Clicking_the_OffersButton_Navigates_to_Offers_Page");
		homepage.OffersButtonClick();
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.phptravels.net/offers");		
		}
		   
	//Verifying whether the text of the OffersButton matches with the expectations or not TC #15
		@Test
		public void Checking_the_Text_Of_the_Offersbutton() {
		test=extent.createTest("Checking_the_Text_Of_the_Offersbutton");
		String Text=homepage.OffersButtonText();
		Assert.assertEquals(Text, "OFFERS");
		}
	
	//Verifying whether hotel gets booked for a user or not TC #16
		@Test
		public void Booking_Hotels_for_User() {
		test=extent.createTest("Booking_Hotels_for_User");
		homepage.Hotelbooking();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Search Results");
		}
		
		
	//Verifying whether flights get booked one-way for a user or not TC #17
		/*@Test
		public void Booking_One_Way_Flight_for_User() {
		homepage.OneWayFlightBooking();
		}*/	
	
		
	//Verifying whether Car gets booked for a user or not TC #17
		@Test
		public void Booking_Cars_for_User() {
		test=extent.createTest("Booking_Cars_for_User");
		homepage.CarBooking();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Cars Listings");
		}

	//Verifying whether Visa gets booked for a user or not TC #18
		@Test
		public void Booking_Visa_for_User() {
		test=extent.createTest("Booking_Visa_for_User");
		homepage.VisaBooking();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Visa");
		}	
		
	//Verifying that all the placards for offer shall be displayed to the user TC #19
		@Test
		public void offer_placards_handling() {
		test=extent.createTest("offer_placards_handling");
		boolean elementdisplay=homepage.offers_placards();
		Assert.assertTrue(elementdisplay);
		}
		
	//Verifying that all the hotel placard works as needed TC #20
		@Test
		public void hotels_placard_handling() {
		test=extent.createTest("hotels_placard_handling");
		homepage.hotel_placards();
		boolean elementdisplay=hotelbooking.modifybutton();
		Assert.assertTrue(elementdisplay);
		}
		
	//Verifying that all the Cars placard works as needed TC #21
		@Test
		public void Cars_placard_handling() {
		test=extent.createTest("Cars_placard_handling");
		homepage.cars_placards();
		boolean elementdisplay=carsbooking.booknowbutton();
		Assert.assertTrue(elementdisplay);
		}
		
	//Verifying that all the Cars placard works as needed TC #22
		@Test
		public void Booking_Tour_for_User() {
		test=extent.createTest("Booking_Tour_for_User");
		homepage.TourBooking();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Tours Listings");
		}
		
	//Verifying that all the Cars placard works as needed TC #23
		@Test
		public void Tour_placard_handling() {
		test=extent.createTest("Tour_placard_handling");
		homepage.tour_placards();
		boolean elementdisplay=tourbooking.booknowbutton();
		Assert.assertTrue(elementdisplay);
		}
			
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

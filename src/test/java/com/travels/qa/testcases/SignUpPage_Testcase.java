package com.travels.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestLists;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.SignUpPage;

public class SignUpPage_Testcase extends TestBase{
	
	SignUpPage signup;
	HomePage homepage;
	TestLists list;

	public SignUpPage_Testcase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		signup=new SignUpPage();
		homepage=new HomePage();
		list=new TestLists();
	}
	//Verifying whether the texts of the TextBoxes meet the expectations or not TC #1
	@Test
	public void Title_Of_The_TextBoxes() {
		test=extent.createTest("Title_Of_The_TextBoxes");
		homepage.Signup();
		List<WebElement> elements=signup.TextBoxTitles();
		String firstname=elements.get(0).getText();
		Assert.assertEquals(firstname,"First Name");
		String lastname=elements.get(1).getText();
		Assert.assertEquals(lastname,"Last Name");
		String mobilenumber=elements.get(2).getText();
		Assert.assertEquals(mobilenumber,"Mobile Number");
		String email=elements.get(3).getText();
		Assert.assertEquals(email,"Email");
		String password=elements.get(4).getText();
		Assert.assertEquals(password,"Password");
		String confirmpassword=elements.get(5).getText();
		Assert.assertEquals(confirmpassword,"Confirm Password");
	}
	
	//Verifying whether the text inside the TextBoxes meet the expectations or not TC #2
	@Test
	public void Text_Inside_The_TextBoxes() {
		test=extent.createTest("Text_Inside_The_TextBoxes");
		homepage.Signup();
		List<String> texts=signup.TextInsideTextBoxes();
		String firstname=texts.get(0);
		Assert.assertEquals(firstname,"First Name");
		String lastname=texts.get(1);
		Assert.assertEquals(lastname,"Last Name");
		String mobilenumber=texts.get(2);
		Assert.assertEquals(mobilenumber,"Mobile Number");
		String email=texts.get(3);
		Assert.assertEquals(email,"Email");
		String password=texts.get(4);
		Assert.assertEquals(password,"Password");
		String confirmpassword=texts.get(5);
		Assert.assertEquals(confirmpassword,"Confirm Password");
	}
	
	//Verifying if we click the SignUp without entering any TextField the actual error matches with the expected error TC #3
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_no_textfield_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_no_textfield_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_without_any_field_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.No_Field_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}

	//Verifying if we click the SignUp by entering FirstName, the actual error matches with the expected error TC #4
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_firstname_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_firstname_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_FirstName_field_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.FirstName_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}

	//Verifying if we click the SignUp by entering LastName, the actual error matches with the expected error TC #5
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_lastname_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_lastname_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_LastName_field_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.LastName_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}

	//Verifying if we click the SignUp by entering email, the actual error matches with the expected error TC #6
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_email_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_email_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_Email_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.Email_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}

	//Verifying if we click the SignUp by entering Password, the actual error matches with the expected error TC #7
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_password_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_password_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_Password_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.Password_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}

	//Verifying if we click the SignUp by entering ConfirmPassword, the actual error matches with the expected error TC #8
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_confirmpassword_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_confirmpassword_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_ConfirmPassword_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.ConfirmPassword_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}
	
	//Verifying if we click the SignUp by entering mismatched ConfirmPassword and Password, the actual error matches with the expected error TC #9
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_mismatched_confirmpassword_and_Password_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_mismatched_confirmpassword_and_Password_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_mismatched_Password_and_ConfirmPassword_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.Mismatched_Confirmpassword_and_Password_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}
	
	//Verifying if we click the SignUp by entering matched ConfirmPassword and Password, the actual error matches with the expected error TC #10
	@Test
	public void Matching_the_Actual_with_Expected_errors_if_matched_confirmpassword_and_Password_is_Entered() {
		test=extent.createTest("Matching_the_Actual_with_Expected_errors_if_matched_confirmpassword_and_Password_is_Entered");
		homepage.Signup();
		List<String> ActualListOfErrors=list.Signup_button_click_when_matched_Password_and_ConfirmPassword_entered();
		List<String> ExpectedListOfErrors=new ArrayList<String>();
		List<WebElement> value=signup.Matched_Confirmpassword_and_Password_Entered();
		for(int j=0;j<value.size();j++) {
			ExpectedListOfErrors.add(value.get(j).getText());
		}
		Assert.assertEquals(ExpectedListOfErrors, ActualListOfErrors);
	}
	
	//Verifying after SignUp form filling the user lands on the Account Page #11
	@Test
	public void Filling_the_Form_Of_SignUp() {
		test=extent.createTest("Filling_the_Form_Of_SignUp");
		homepage.Signup();
		signup.SignUp_Form();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "My Account");
	}

	//Verifying that if we click the subscription button the user shall get subscribed #12
		@Test
		public void Clicking_the_Subscription_Button() {
		test=extent.createTest("Clicking_the_Subscription_Button");
		homepage.Signup();
		String text=signup.Subscription_To_NewsFeed();
		Assert.assertEquals(text, "SUBSCRIBED SUCCESSFULLY");
		}
		
	//Verifying that if we click the subscription button twice, the message user already subscribed shall be displayed #13
		@Test
		public void Clicking_the_Subscription_Button_If_User_Already_Exists() {
		test=extent.createTest("Clicking_the_Subscription_Button_If_User_Already_Exists");
		homepage.Signup();
		String text=signup.Subscription_if_already_exsists_To_NewsFeed();
		Assert.assertEquals(text, "ALREADY SUBSCRIBED");
		}
		
	//Verifying that if Google Play Button is clicked the user is navigated to the google play store #14
		@Test
		public void GooglePlayButton_navigates_to_GooglePlayStore() {
		test=extent.createTest("GooglePlayButton_navigates_to_GooglePlayStore");
		homepage.Signup();
		signup.GooglePlayButton();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "PHPTRAVELS Native - Apps on Google Play");
		}
		
	//Verifying that if App Store Button is clicked the user is navigated to the Connecting to App store Page #15
		@Test
		public void AppStoreButton_navigates_to_ConnectingToAppStore() {
		test=extent.createTest("AppStoreButton_navigates_to_ConnectingToAppStore");
		homepage.Signup();
		signup.AppStoreButton();
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Connecting to the iTunes Store.");
		}

		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
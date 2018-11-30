package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.pages.AccountPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.SignUpPage;
import com.travels.qa.utility.Testutility;

public class Account_Testcase extends TestBase {
	
	HomePage homepage;
	Testutility utility;
	SignUpPage signup;
	AccountPage account;

	public Account_Testcase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		signup=new SignUpPage();
		account=new AccountPage();
	}
	
	//Verifying that all the details of the user gets filled TC #1
	@Test
	public void Details_Entry_Of_Users_Profile() {
	test=extent.createTest("Details_Entry_Of_Users_Profile");
	homepage.Signup();
	signup.SignUp_Form();
	boolean messagedisplay=account.details_fillup();
	Assert.assertTrue(messagedisplay);
	}
	
	//Verifying that upon clicking the logo the user lands on the main applications homepage TC #2
	@Test
	public void Logo_Click_Navigates_to_Homescreen() {
	test=extent.createTest("Logo_Click_Navigates_to_Homescreen");
	homepage.Signup();
	signup.SignUp_Form();
	account.homescreen_navigate();
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "PHPTRAVELS | Travel Technology Partner");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

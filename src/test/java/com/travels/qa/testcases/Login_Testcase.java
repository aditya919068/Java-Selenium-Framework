package com.travels.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.pages.AccountPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.pages.LoginPage;


public class Login_Testcase extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestWait wait;
	AccountPage accountpage;

	public Login_Testcase() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		wait=new TestWait();
		accountpage=new AccountPage();
		
	}
	
	//Verify that the TextField Titles match with the expectations TC #1
	@Test
	public void Verifying_text_field_titles() {
	test=extent.createTest("Verifying_text_field_titles");
	homepage.Login();
	List<WebElement> element=loginpage.TextVerification();
	wait.VisibilityOfAllElements(element);
	String email=element.get(0).getText();
	Assert.assertEquals(email, "Email");
	String password=element.get(1).getText();
	Assert.assertEquals(password, "Password");
	String rememberme=element.get(2).getText();
	Assert.assertEquals(rememberme, "  Remember Me  ");
	}
	
	//Verifying whether the text inside the TextBoxes meet the expectations or not TC #2
	@Test
	public void Text_Inside_The_TextBoxes() {
	test=extent.createTest("Text_Inside_The_TextBoxes");
	homepage.Login();
	List<WebElement> element=loginpage.TextVerification();
	wait.VisibilityOfAllElements(element);
	List<String> texts=loginpage.TextInsideTextBoxes();
	String emailtext=texts.get(0);
	Assert.assertEquals(emailtext,"Email");
	String passwordtext=texts.get(1);
	Assert.assertEquals(passwordtext,"Password");
	}
	
	//Verifying the error message if both email and password Text fields are left empty and the login button is clicked TC #3
	@Test
	public void Error_Message_On_login_click_if_both_textfields_are_empty() {
	test=extent.createTest("Error_Message_On_login_click_if_both_textfields_are_empty");
	homepage.Login();
	String text=loginpage.Login_without_textfields_entered();
	Assert.assertEquals(text, "Invalid Email or Password");
	}

	//Verifying the error message if both email and password Text fields are entered randomly without the users existence TC #4
	@Test
	public void Error_Message_On_login_click_if_both_textfields_are_entered_not_present_In_Database() {
	test=extent.createTest("Error_Message_On_login_click_if_both_textfields_are_entered_not_present_In_Database");
	homepage.Login();
	String text=loginpage.Login_by_entering_credentials_which_do_not_exsist();
	Assert.assertEquals(text, "Invalid Email or Password");
	}
	
	//Verifying that a user can SignUp through the Login Page TC #5
	@Test
	public void Signup_through_login_page() {
	test=extent.createTest("Signup_through_login_page");
	homepage.Login();
	loginpage.Signup_through_loginpage();
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "My Account");
	}
	
	//Verifying that a user can SignUp through the Login Page and logout after that TC #6
	@Test
	public void Signup_through_login_page_and_logout() {
	test=extent.createTest("Signup_through_login_page_and_logout");
	homepage.Login();
	loginpage.Signup_through_loginpage();
	accountpage.Logout_from_LoggedIn_Account();
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "Login");
	}

		
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}

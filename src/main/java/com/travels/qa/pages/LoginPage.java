package com.travels.qa.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;

public class LoginPage extends TestBase {
	
TestWait wait=new TestWait();
SignUpPage signupPage=new SignUpPage();
AccountPage accountpage=new AccountPage();
Random random=new Random();

@FindBy(xpath="//label[text()='Email']")
WebElement emailtextboxtext;

@FindBy(xpath="//input[@name='username']")
WebElement emailtextbox;

@FindBy(xpath="//label[text()='Password']")
WebElement passwordtextboxtext;

@FindBy(xpath="//input[@name='password']")
WebElement passwordtextbox;

@FindBy(xpath="//span[@class='go-left'][contains(text(),' ')]")
WebElement RememberMeCheckBoxText;

@FindBy(xpath="//input[@name='remember']")
WebElement RememberMeCheckBox;

@FindBy(xpath="//button[text()='Login']")
WebElement LoginButton;

@FindBy(xpath="//a[text()='Sign Up']")
WebElement SignUpButton;

@FindBy(xpath="//a[text()='Forget Password']")
WebElement ForgetPasswordButton;

@FindBy(xpath="//input[@id='resetemail']")
WebElement ForgetPasswordTextbox;

@FindBy(xpath="//button[text()='Reset']")
WebElement ResetButton;

@FindBy(xpath="//div[text()='Invalid Email or Password']")
WebElement ErrorMessage;

@FindBy(xpath="//div[@class='alert alert-success']")
WebElement ForgetPasswordResetSuccessMessage;

	public LoginPage() {
	PageFactory.initElements(driver, this);	
}

	//Managing TextField titles
	public List<WebElement> TextVerification() {
	List<WebElement> element=new ArrayList<WebElement>();
	element.add(emailtextboxtext);
	element.add(passwordtextboxtext);
	element.add(RememberMeCheckBoxText);
	return element;
}
	
	//Managing the text inside the TextBoxes
	public List<String> TextInsideTextBoxes() {
	List<String> text_Of_Boxes=new ArrayList<String>();
	String text1=emailtextbox.getAttribute("placeholder");
	String text2=passwordtextbox.getAttribute("placeholder");
	text_Of_Boxes.add(text1);
	text_Of_Boxes.add(text2);
	return text_Of_Boxes;
}
	
	//Managing Click on the login without entering any TextField
	public String Login_without_textfields_entered() {
	LoginButton.click();
	wait.TextToBe_Wait("//div[text()='Invalid Email or Password']", "Invalid Email or Password");
	String text=ErrorMessage.getText();
	return text;
	}

	//Managing Click on the login by entering all TextField's but the value shall not be in the database
	public String Login_by_entering_credentials_which_do_not_exsist() {
	emailtextbox.sendKeys("User"+random.nextInt(100000)+"@gmail.com");
	passwordtextbox.sendKeys("password"+random.nextInt(100000));
	LoginButton.click();
	wait.TextToBe_Wait("//div[text()='Invalid Email or Password']", "Invalid Email or Password");
	String text=ErrorMessage.getText();
	return text;
	}
	
	//Managing to Navigating to SignUp>creating a user and LogingIn
	public AccountPage Signup_through_loginpage() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript( "arguments[0].click();", SignUpButton );
	signupPage.SignUp_Form();
	return new AccountPage();
	}
	
	//Managing the ForgetPassword Dialog of a user
	public String Signup_logout_and_click_forgetpassword() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript( "arguments[0].click();", ForgetPasswordButton );
	String text=signupPage.Email_value_of_the_user();
	wait.SingleElementWait("//input[@id='resetemail']");
	ForgetPasswordTextbox.sendKeys(text);
	ResetButton.click();
	wait.SingleElementWait("//div[@class='alert alert-success']");
	String successmessage=ForgetPasswordResetSuccessMessage.getText();
	return successmessage;
	}
}

package com.travels.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestLists;
import com.travels.qa.common.TestWait;

public class SignUpPage extends TestBase {

TestLists list=new TestLists();
TestWait wait = new TestWait();
Random radomvalue=new Random();

	
@FindBy(xpath="//label[text()='First Name']")
WebElement FirstElementTitle;

@FindBy(xpath="//label[text()='Last Name']")
WebElement SecondElementTitle;

@FindBy(xpath="//label[text()='Mobile Number']")
WebElement ThirdElementTitle;

@FindBy(xpath="//label[text()='Email']")
WebElement FourthElementTitle;

@FindBy(xpath="//label[text()='Password']")
WebElement FifthElementTitle;

@FindBy(xpath="//label[text()='Confirm Password']")
WebElement SixthElementTitle;

@FindBy(xpath="//input[@name='firstname']")
WebElement firstname;

@FindBy(xpath="//input[@name='lastname']")
WebElement lastname;

@FindBy(xpath="//input[@name='phone']")
WebElement mobilenumber;

@FindBy(xpath="//input[@name='email']")
WebElement email;

@FindBy(xpath="//input[@name='password']")
WebElement password;

@FindBy(xpath="//input[@name='confirmpassword']")
WebElement confirmpassword;

@FindBy(xpath="//button[@type='submit' and text()=' Sign Up']")
WebElement submitbutton;

@FindBy(xpath="//div[@class='alert alert-danger']//p")
List<WebElement> ErrorAlert1;

@FindBy(xpath="//input[@id='exampleInputEmail1']")
WebElement SubscriptionTextBox;

@FindBy(xpath="//button[text()=' Subscribe']")
WebElement SubscriptionButton;

@FindBy(xpath="//div[@class='subscriberesponse']")
WebElement SubscriptionText;

@FindBy(xpath="//span[text()='Google Play']")
WebElement GooglePlayButton;

@FindBy(xpath="//span[text()='App Store']")
WebElement AppStoreButton;

public SignUpPage() {
	PageFactory.initElements(driver, this);
}

	//Managing the titles of the TextBoxes
	public List<WebElement> TextBoxTitles() {
	List<WebElement> elements=new ArrayList<WebElement>(); 
	elements.add(FirstElementTitle);
	elements.add(SecondElementTitle);
	elements.add(ThirdElementTitle);
	elements.add(FourthElementTitle);
	elements.add(FifthElementTitle);
	elements.add(SixthElementTitle);
	return elements;
}

	//Managing the text inside the TextBoxes
	public List<String> TextInsideTextBoxes() {
	List<String> text_Of_Boxes=new ArrayList<String>();
	String text1=firstname.getAttribute("placeholder");
	String text2=lastname.getAttribute("placeholder");
	String text3=mobilenumber.getAttribute("placeholder");
	String text4=email.getAttribute("placeholder");
	String text5=password.getAttribute("placeholder");
	String text6=confirmpassword.getAttribute("placeholder");
	text_Of_Boxes.add(text1);
	text_Of_Boxes.add(text2);
	text_Of_Boxes.add(text3);
	text_Of_Boxes.add(text4);
	text_Of_Boxes.add(text5);
	text_Of_Boxes.add(text6);
	return text_Of_Boxes;
}
	//Managing the alert if no field has been entered and SignUp button is clicked
	public List<WebElement> No_Field_Entered() {
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}

	//Managing the alert if FirstName has been entered and SignUp button is clicked
	public List<WebElement> FirstName_Entered() {
	firstname.sendKeys("FN"+radomvalue.nextInt(10000));
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}

	//Managing the alert if LastName has been entered and SignUp button is clicked
	public List<WebElement> LastName_Entered() {
	lastname.sendKeys("LN"+radomvalue.nextInt(10000));
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}
	
	//Managing the alert if FirstName has been entered and SignUp button is clicked
	public List<WebElement> Email_Entered() {
	email.sendKeys("user"+radomvalue.nextInt(100000)+"@gmail.com");
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}

	//Managing the alert if Password has been entered and SignUp button is clicked
	public List<WebElement> Password_Entered() {
	password.sendKeys("password"+radomvalue.nextInt(10000));
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}
	
	//Managing the alert if ConfirmPassword has been entered and SignUp button is clicked
	public List<WebElement> ConfirmPassword_Entered() {
	confirmpassword.sendKeys("confirm"+radomvalue.nextInt(10000));
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}
	
	//Managing the alert if mismatched ConfirmPassword and password has been entered and SignUp button is clicked
	public List<WebElement> Mismatched_Confirmpassword_and_Password_Entered() {
	password.sendKeys("password"+radomvalue.nextInt(10000));
	confirmpassword.sendKeys("confirm"+radomvalue.nextInt(10000));
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}
	
	//Managing the alert if matched ConfirmPassword and password has been entered and SignUp button is clicked
	public List<WebElement> Matched_Confirmpassword_and_Password_Entered() {
	password.sendKeys("password"+radomvalue.nextInt(10000));
	String savedval=password.getAttribute("value");
	confirmpassword.sendKeys(savedval);
	submitbutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger']");
	List<WebElement> value =ErrorAlert1;
	return value;
}
	
	//Managing the Complete SignUp Form
	public AccountPage SignUp_Form() {
	firstname.sendKeys("FN"+radomvalue.nextInt(10000));
	lastname.sendKeys("LN"+radomvalue.nextInt(10000));
	email.sendKeys("user"+radomvalue.nextInt(100000)+"@gmail.com");
	password.sendKeys("password"+radomvalue.nextInt(10000));
	String savedval=password.getAttribute("value");
	confirmpassword.sendKeys(savedval);
	submitbutton.click();
	wait.URL_Wait("https://www.phptravels.net/account/");
	return new AccountPage();
}
	//Managing the Email value of the user
	public String Email_value_of_the_user() {
	wait.SingleElementWait("//input[@name='firstname']");
	firstname.sendKeys("FN"+radomvalue.nextInt(10000));
	lastname.sendKeys("LN"+radomvalue.nextInt(10000));
	email.sendKeys("user"+radomvalue.nextInt(100000)+"@gmail.com");
	String emailValue=email.getAttribute("value");
	password.sendKeys("password"+radomvalue.nextInt(10000));
	String savedval=password.getAttribute("value");
	confirmpassword.sendKeys(savedval);
	submitbutton.click();
	wait.URL_Wait("https://www.phptravels.net/account/");
	return emailValue;
}
	
	//Managing the Subscription to NewsFeed
	public String Subscription_To_NewsFeed() {
	SubscriptionTextBox.sendKeys("user"+radomvalue.nextInt(100000)+"@gmail.com");
	SubscriptionButton.click();
	wait.SingleElementWait("//div[@class='subscriberesponse']");
	String text=SubscriptionText.getText();
	return text;
	}
	
	//Managing the Subscription if User already exists to NewsFeed
	public String Subscription_if_already_exsists_To_NewsFeed() {
	SubscriptionTextBox.sendKeys("user"+radomvalue.nextInt(100000)+"@gmail.com");
	SubscriptionButton.click();
	wait.SingleElementWait("//div[@class='subscriberesponse']");
	SubscriptionButton.click();
	wait.TextToBe_Wait("//div[@class='subscriberesponse']", "ALREADY SUBSCRIBED");
	String text=SubscriptionText.getText();
	return text;
	}
	
	//Managing the Google Play Button click
	public void GooglePlayButton() {
	GooglePlayButton.click();
	ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	}
	
	//Managing the App Store Button click
	public void AppStoreButton() {
	AppStoreButton.click();
	ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	}
}
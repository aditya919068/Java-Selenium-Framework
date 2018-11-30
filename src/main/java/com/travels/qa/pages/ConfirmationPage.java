package com.travels.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class ConfirmationPage extends TestBase {
	
	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	Random rad=new Random();
	
	@FindBy(xpath = "//button[text()='CONFIRM THIS BOOKING']")
	WebElement ConfirmationButton;
	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement GuestFirstname;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement GuestLastname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement GuestEmail;
	
	@FindBy(xpath = "//input[@name='confirmemail']")
	WebElement GuestConfirmEmail;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement GuestPhone;
	
	@FindBy(xpath = "//input[@name='address']")
	WebElement GuestAddress;
	
	@FindBy(xpath = "//a[@id='signintab']")
	WebElement SigninTab;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement SigninEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement SigninPassword;
	
	@FindBy(xpath = "//div[text()='Invalid Email or Password']")
	WebElement ErrorMessage;
	
	@FindBy(xpath = "(//div[@class='control__indicator'])[1]")
	WebElement AddMessageCheckbox;
	
	@FindBy(xpath = "//textarea[@name='additionalnotes']")
	WebElement AddmessageTextbox;
	
	
	public ConfirmationPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Managing the visibility of confirmation Button
	public boolean confirmation_button() {
	boolean element=ConfirmationButton.isDisplayed();
	return element;
	}

	//Managing form fill as a guest
	public InvoicePage Confirmation_As_A_Guest() {
	GuestFirstname.sendKeys("First"+rad.nextInt(100000));
	GuestLastname.sendKeys("Last"+rad.nextInt(100000));
	String FN=GuestFirstname.getAttribute("value");
	GuestEmail.sendKeys(FN+"@gmail.com");
	String Mail=GuestEmail.getAttribute("value");
	GuestConfirmEmail.sendKeys(Mail);
	GuestPhone.sendKeys("0"+rad.nextInt(1000000000));
	GuestAddress.sendKeys("Address"+rad.nextInt(1000000));
	ConfirmationButton.click();
	return new InvoicePage();
	}
	
	//Managing FormFill as a permanent user
	public void Confirmation_As_A_Permanent_User() {
	ConfirmationButton.click();
	}
	
	//Managing formfill as an already Exsisting user but with invalid id/password
	public boolean Exsisting_user_with_invalid_Id_password() {
	SigninTab.click();
	SigninEmail.sendKeys("User"+rad.nextInt(100000));
	SigninPassword.sendKeys("password"+rad.nextInt(100000));
	ConfirmationButton.click();
	wait.SingleElementWait("//div[text()='Invalid Email or Password']");
	boolean messagedisplay=ErrorMessage.isDisplayed();
	return messagedisplay;
	}
	
	//Managing to add notes in the order
	public void Add_Message() {
	AddMessageCheckbox.click();
	AddmessageTextbox.sendKeys("Notes of the user");
	}
}

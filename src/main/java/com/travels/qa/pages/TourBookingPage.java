package com.travels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class TourBookingPage extends TestBase{
	
	Testutility util = new Testutility();
	TestWait wait = new TestWait();

	@FindBy(xpath = "//button[text()='Book Now']")
	WebElement BookNowButton;
	
	@FindBy(xpath = "//input[@class='form-control form-group tchkin']")
	WebElement ChangeDateTextbox;

	@FindBy(xpath = "//button[text()='Change Date']")
	WebElement ChangeDateButton;
	
	@FindBy(xpath = "//span[text()='Booking Options']")
	WebElement ElementClick;
	
	public TourBookingPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Managing the visibility of booknow Button
	public boolean booknowbutton() {
	boolean element=BookNowButton.isDisplayed();
	return element;
	}
	
	//Managing tour booking for the user
	public ConfirmationPage tourbooking() {
	BookNowButton.click();
	return new ConfirmationPage();
	}
	
	//Managing tour change of date
	public void DateChange() {
	ChangeDateTextbox.clear();
	String date=util.Past_Current_Date();
	ChangeDateTextbox.sendKeys(date);
	ElementClick.click();
	ChangeDateButton.click();
	wait.SingleElementWait("//button[text()='Book Now']");
	BookNowButton.click();
	}

}

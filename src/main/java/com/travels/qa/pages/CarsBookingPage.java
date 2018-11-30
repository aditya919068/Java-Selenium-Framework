package com.travels.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class CarsBookingPage extends TestBase {

	Testutility util = new Testutility();
	TestWait wait = new TestWait();

	
	@FindBy(xpath = "//button[text()='Book Now']")
	WebElement BookNowButton;
	
	@FindBy(xpath = "(//span[text()='Select Location'])[1]")
	WebElement PickUp;
	
	public CarsBookingPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Managing the visibility of booknow Button
	public boolean booknowbutton() {
	boolean element=BookNowButton.isDisplayed();
	return element;
	}
	
	//Booking a car for a location
	public ConfirmationPage booking_car() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1200)", "");
	PickUp.click();
	util.MyAccountDropDown("//ul[@class='select2-results']/li", "Sharjah");
	wait.SingleElementWait("//div[@class='col-xs-12 well well-sm text-center']");
	BookNowButton.click();
	return new ConfirmationPage();
	}
}

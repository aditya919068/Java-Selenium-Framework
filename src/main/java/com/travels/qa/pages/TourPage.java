package com.travels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class TourPage extends TestBase {
	
	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	
	@FindBy(xpath = "(//button[text()='Details'])[1]")
	WebElement TourDetailButton;
	
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[3]")
	WebElement StarFilter;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement SearchButton;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[7]")
	WebElement TourTypeFilter;


	public TourPage() {
	PageFactory.initElements(driver, this);
	}

	//Navigating to the Tour Details Page
	public TourBookingPage Tour_Booking() {
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	TourDetailButton.click();
	return new TourBookingPage();
	}
	
	//Managing filter through Stars
	public boolean star_filter() {
	StarFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=TourDetailButton.isDisplayed();
	return elementdisplay;
	}
	
	//Managing filter through Cars type filter
	public boolean tour_type_filter() {
	TourTypeFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=TourDetailButton.isDisplayed();
	return elementdisplay;
	}

}

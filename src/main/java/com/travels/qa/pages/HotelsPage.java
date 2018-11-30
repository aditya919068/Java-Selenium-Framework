package com.travels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class HotelsPage extends TestBase {

	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	
	@FindBy(xpath = "(//button[text()='Details'])[1]")
	WebElement HotelsDetailButton;
	
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[3]")
	WebElement StarFilter;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement SearchButton;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[7]")
	WebElement PropertyTypeFilter;
	
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[21]")
	WebElement AmenitiesFilter;
	
	public HotelsPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Navigating to the hotels Details Page
	public HotelBookingPage Hotel_Booking() {
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	HotelsDetailButton.click();
	return new HotelBookingPage();
	}
	
	//Managing filter through Stars
	public boolean star_filter() {
	StarFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=HotelsDetailButton.isDisplayed();
	return elementdisplay;
	}
	
	//Managing filter through property type filter
	public boolean property_type_filter() {
	PropertyTypeFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=HotelsDetailButton.isDisplayed();
	return elementdisplay;
	}
	
	//Managing filter through Amenities type filter
	public boolean Amenities_type_filter() {
	AmenitiesFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=HotelsDetailButton.isDisplayed();
	return elementdisplay;
	}	
	
}

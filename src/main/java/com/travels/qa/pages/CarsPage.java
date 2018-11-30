package com.travels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class CarsPage extends TestBase {
	
	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	
	@FindBy(xpath = "(//button[text()='Details'])[1]")
	WebElement CarsDetailButton;
	
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[3]")
	WebElement StarFilter;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement SearchButton;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[7]")
	WebElement CarTypeFilter;
	
	public CarsPage() {
	PageFactory.initElements(driver, this);
	}
	
	
	//Navigating to the Cars Details Page
	public CarsBookingPage Cars_Booking() {
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	CarsDetailButton.click();
	return new CarsBookingPage();
	}
	
	//Managing filter through Stars
	public boolean star_filter() {
	StarFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=CarsDetailButton.isDisplayed();
	return elementdisplay;
	}
	
	//Managing filter through Cars type filter
	public boolean cars_type_filter() {
	CarTypeFilter.click();
	SearchButton.click();
	wait.SingleElementWait("(//button[text()='Details'])[1]");
	boolean elementdisplay=CarsDetailButton.isDisplayed();
	return elementdisplay;
	}
	


}

package com.travels.qa.pages;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class HotelBookingPage extends TestBase {

	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	Random rad=new Random();
	
	@FindBy(xpath = "//input[@class='btn btn-block btn-success-small textupper loader']")
	WebElement ModificationButton;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement CheckinDate;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement CheckoutDate;
	
	@FindBy(xpath = "//select[@id='adults']")
	WebElement NoOfIndividualsDD;
	
	@FindBy(xpath = "(//div[@class='control__indicator'])[1]")
	WebElement RoomSelectionCheckbox;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement BookNowButton;
	
	@FindBy(xpath = "(//button[@class='hidden-xs btn btn-default btn-block btn-sm'])[1]")
	WebElement DetailsOfRoombutton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger panel-collapse collapse in']")
	WebElement Details;
	
	@FindBy(xpath = "(//button[text()='Availability'])[1]")
	WebElement RoomAvailabilitybutton;
	
	@FindBy(xpath = "(//select[@class='form-control showcalendar'])[1]")
	WebElement AvailabilityDatesDD;
	
	@FindBy(xpath = "//div[@class='alert alert-info panel-collapse collapse in']")
	WebElement AvailabilityDetails;
	
	@FindBy(xpath = "//button[@class='writeReview btn btn-primary btn-block']")
	WebElement ReviewWritingButton;

	@FindBy(xpath = "//input[@name='fullname']")
	WebElement FullNameForReview;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement MailForReview;
	
	@FindBy(xpath = "//textarea[@name='reviews_comments']")
	WebElement MessageForReview;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg addreview']")
	WebElement SubmittingReviewButton;
	
	@FindBy(xpath = "//select[@name='reviews_clean']")
	WebElement Rating_CleanDD;
	
	@FindBy(xpath = "//select[@name='reviews_facilities']")
	WebElement Rating_facilityDD;

	@FindBy(xpath = "//select[@name='reviews_comfort']")
	WebElement Rating_comfortDD;
	
	@FindBy(xpath = "//select[@name='reviews_staff']")
	WebElement Rating_staffDD;
	
	@FindBy(xpath = "//select[@name='reviews_location']")
	WebElement Rating_locationDD;

	@FindBy(xpath = "//div[text()='Review Posted Successfully']")
	WebElement ReviewSubmissionmessage;
	
	@FindBy(xpath = "//span[@class='btn wish addwishlist btn-danger btn-outline btn-block']")
	WebElement WishListButton;
	
	
	public HotelBookingPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Managing the visibility of Modify Button
	public boolean modifybutton() {
	boolean element=ModificationButton.isDisplayed();
	return element;
	}
	
	//Managing updation of hotel confirmation
	//The page is causing an error, may be due to automation script still I am attaching the below code for knowledge.
	public void Updating_Hotel_Confirmation() {
	util.DropDowns(NoOfIndividualsDD, 2);
	ModificationButton.click();
	CheckinDate.clear();
	String checkingInDate=util.Past_Current_Date();
	CheckinDate.sendKeys(checkingInDate);
	CheckoutDate.clear();
	String checkingOutDate=util.Past_Current_Date2();
	CheckoutDate.sendKeys(checkingOutDate);
	ModificationButton.click();
	}
	
	//Managing room type selection
	public ConfirmationPage Room_Type_Selection() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1300)", "");
	RoomSelectionCheckbox.click();
	wait.SingleElementWait("(//div[@class='control__indicator'])[1]");
	BookNowButton.click();
	return new ConfirmationPage();
	}
	
	//Managing the details of the room button
	public boolean details_button_click() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1300)", "");
	DetailsOfRoombutton.click();
	wait.SingleElementWait("//div[@class='alert alert-danger panel-collapse collapse in']");
	boolean detailsdisplay=Details.isDisplayed();
	return detailsdisplay;
	}
	
	//Checking the Availability of the room
	public boolean Check_Availability() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1300)", "");
	RoomAvailabilitybutton.click();
	util.DropDowns(AvailabilityDatesDD, 1);
	wait.SingleElementWait("//div[@class='alert alert-info panel-collapse collapse in']");
	boolean detailsdisplay=AvailabilityDetails.isDisplayed();
	return detailsdisplay;
	}
	
	//Reviewing a room
	public boolean Room_review() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2500)", "");
	ReviewWritingButton.click();
	FullNameForReview.sendKeys("User"+rad.nextInt(100000));
	String name=FullNameForReview.getAttribute("value");
	MailForReview.sendKeys(name+"@gmail.com");
	MessageForReview.sendKeys("This is a review message");
	util.DropDowns(Rating_CleanDD, 7);
	util.DropDowns(Rating_comfortDD, 7);
	util.DropDowns(Rating_facilityDD, 7);
	util.DropDowns(Rating_locationDD, 7);
	util.DropDowns(Rating_staffDD, 7);
	SubmittingReviewButton.click();
	wait.SingleElementWait("//div[text()='Review Posted Successfully']");
	boolean displayelement=ReviewSubmissionmessage.isDisplayed();
	return displayelement;
	}
	
	//Adding Hotel to wishlist without login
	public String WishList() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2500)", "");
	WishListButton.click();
	Alert alert=driver.switchTo().alert();
	String alertmessage=alert.getText();
	alert.accept();
	return alertmessage;
	}
}
package com.travels.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class InvoicePage extends TestBase {
	
	TestWait wait=new TestWait();
	Testutility util=new Testutility();
	
	@FindBy(xpath = "//input[@class='btn btn-success']")
	WebElement PrintButton;
	
	@FindBy(xpath = "//button[text()='Pay on Arrival']")
	WebElement PayOnArrivalButton;
	
	@FindBy(xpath = "//b[text()='Reserved']")
	WebElement SuccessfulReservationText;
	
	@FindBy(xpath = "(//button[text()='Pay Now'])[1]")
	WebElement PayNowButton;
	
	@FindBy(xpath = "//select[@name='gateway']")
	WebElement PaymentMethods;
	
	@FindBy(xpath = "//input[@class='paybtn']")
	WebElement PayPalButton;
	
	@FindBy(xpath = "//div[text()='Invoice']")
	WebElement InvoiceVisibility;
	
	
	public InvoicePage() {
	PageFactory.initElements(driver, this);
	}
	

	//Managing the visibility of Modify Button
	public boolean printbutton() {
	wait.SingleElementWait("//input[@class='btn btn-success']");
	boolean element=PrintButton.isDisplayed();
	return element;
	}


	//Managing payment on Arrival
	public boolean payment_arrival() {
	wait.SingleElementWait("//button[text()='Pay on Arrival']");
	PayOnArrivalButton.click();
	Alert alert=driver.switchTo().alert();
	alert.accept();
	wait.SingleElementWait("//b[text()='Reserved']");
	boolean textdisplay=SuccessfulReservationText.isDisplayed();
	return textdisplay;
	}
	
	//Managing payment Now
	public void payment_Now() {
	wait.SingleElementWait("//button[text()='Pay on Arrival']");
	PayNowButton.click();
	util.DropDowns(PaymentMethods, 2);
	wait.SingleElementWait("//input[@class='paybtn']");
	PayPalButton.click();
	wait.SingleElementWait("//div[@class='span11 alignRight baslLoginButtonContainer']/a[text()='Log In']");
	}
	
	//Managing the visibility of the invoice to the user
	public boolean Invoice_Visibility() {
	wait.SingleElementWait("//button[text()='Pay on Arrival']");
	boolean textdisplay=InvoiceVisibility.isDisplayed();
	return textdisplay;
	}
}
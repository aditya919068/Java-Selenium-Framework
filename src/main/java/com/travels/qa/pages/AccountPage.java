package com.travels.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class AccountPage extends TestBase {
	
	Testutility util=new Testutility();
	TestWait wait = new TestWait();
	Random rad=new Random();
	
	@FindBy(xpath="(//a[@class='dropdown-toggle go-text-right'])[3]")
	WebElement Userdropdown;

	@FindBy(xpath="//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement PhoneNumber ;

	@FindBy(xpath="//input[@name='address1']")
	WebElement Address ;

	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@name='zip']")
	WebElement ZipCode;

	@FindBy(xpath="//select[@name='country']")
	WebElement CountryDD;
	
	@FindBy(xpath="//button[text()=' Submit ']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//div[text()='Profile Updated Successfully.']")
	WebElement SuccessMessage;
	
	@FindBy(xpath="(//ul[@class='nav profile-tabs']/li)[2]")
	WebElement MyProfileTab;
	
	@FindBy(xpath="//a[@class='navbar-brand go-right']")
	WebElement LogoClick;
	

	public AccountPage() {
	PageFactory.initElements(driver, this);
	}

	// Managing the DropDown from a users account
	public SignUpPage Logout_from_LoggedIn_Account() {
	Userdropdown.click();
	wait.SingleElementWait("(//ul[@class='dropdown-menu'])[2]");
	util.MyAccountDropDown("(//ul[@class='dropdown-menu'])[2]/li", "Logout");
	return new SignUpPage();
	}
	
	//Managing Details of the user's profile
	public boolean details_fillup() {
	MyProfileTab.click();
	PhoneNumber.sendKeys("0"+rad.nextInt(1000000000));
	Address.sendKeys("House no:"+rad.nextInt(10000)+" "+"Sector"+rad.nextInt(100));
	City.sendKeys("Chandigarh");
	State.sendKeys("Chandigarh");
	ZipCode.sendKeys("1"+rad.nextInt(100000));
	util.DropDowns(CountryDD, 79);
	SubmitButton.click();
	wait.SingleElementWait("//div[text()='Profile Updated Successfully.']");
	boolean MessageDisplay=SuccessMessage.isDisplayed();
	return MessageDisplay;
	}
	
	//Managing Navigation to the Homescreen
	public void homescreen_navigate() {
	LogoClick.click();
	}
}

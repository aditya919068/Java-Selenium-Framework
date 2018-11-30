package com.travels.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class OffersPage extends TestBase {
	
	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	Random rad=new Random();
	
	@FindBy(xpath = "//div[@class='col-md-6 owl-item go-right']")
	WebElement ContentCards;
	
	@FindBy(xpath = "(//a[@class='btn btn-primary go-right loader'])[2]")
	WebElement ContentCardsReadMore;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement NameTextBox;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement PhoneTextBox;
	
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement MessageTextBox;
	
	@FindBy(xpath = "//input[@class='btn btn-success btn-success btn-block btn-lg']")
	WebElement ContactButton;
	
	@FindBy(xpath = "//div[text()='Thanks For Contacting']")
	WebElement OfferAcceptanceMessage;
	
	
	public OffersPage() {
	PageFactory.initElements(driver, this);
	}

	//Managing the read more button of the articles
	public boolean readmore_button() {
	boolean displayofelements=false;
	List<WebElement> element=driver.findElements(By.xpath("(//a[@class='btn btn-primary go-right loader'])"));
	for(int i=1;i<=element.size();i++) {
	driver.findElement(By.xpath("(//a[@class='btn btn-primary go-right loader'])["+i+"]")).click();
	driver.navigate().back();
	displayofelements=ContentCards.isDisplayed();
	}
	return displayofelements;
	}
	
	//Managing and getting an offer
	public boolean Applying_for_offer() {
	ContentCardsReadMore.click();
	NameTextBox.sendKeys("User"+rad.nextInt(1000000));
	PhoneTextBox.sendKeys("0"+rad.nextInt(1000000000));
	MessageTextBox.sendKeys("I want this offer");
	ContactButton.click();
	wait.SingleElementWait("//div[text()='Thanks For Contacting']");
	boolean displaymessage=OfferAcceptanceMessage.isDisplayed();
	return displaymessage;
	}
}

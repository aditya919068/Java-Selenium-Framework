package com.travels.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestLists;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class HomePage extends TestBase {

	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	TestLists lists=new TestLists();
	Actions action=new Actions(driver);
	
	@FindBy(xpath = "(//a[text()=' My Account '])[2]")
	WebElement MyAccount;
	
	@FindBy(xpath="(//li[@class='dropdown']//a[@class='dropdown-toggle go-text-right'])[2]")
	WebElement Currency;
	
	@FindBy(xpath="(//li[@class='dropdown']//a[@class='go-text-right dropdown-toggle'])[2]")
	WebElement Language;
	
	@FindBy(xpath="//a[@class='navbar-brand go-right']//img[@alt='PHPTRAVELS | Travel Technology Partner']")
	WebElement Logo;
	
	@FindBy(xpath="//span[@class='contact-no align-M' and text()='Call Now: ']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//span[@class='tp-mail']//a[text()='info@phptravels.com']")
	WebElement MailAddress;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement HomeButton;
	
	@FindBy(xpath="//a[text()='Blog     ']")
	WebElement BlogButton;
	
	@FindBy(xpath="//a[text()='Offers   ']")
	WebElement OffersButton;

	@FindBy(xpath="//span[text()='Search by Hotel or City Name']")
	WebElement HotelsTab;
	
	@FindBy(xpath="//input[@class='select2-input select2-focused']")
	WebElement HotelsSearchbar;
	
	@FindBy(xpath="//input[@class='form input-lg dpd1']")
	WebElement HotelsCheckinDate;
	
	@FindBy(xpath="//input[@class='form input-lg dpd2']")
	WebElement HotelsCheckOutDate;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
	WebElement HotelSearchButton;
	
	@FindBy(xpath="(//a[@class='text-center'])[2]")
	WebElement FlightsTab;
	
	@FindBy(xpath="(//span[text()='Enter City Or Airport'])[1]")
	WebElement DepartingAirport;
	
	@FindBy(xpath="//input[@class='select2-input select2-focused']")
	WebElement DepartingAirportTextBox;
	
	@FindBy(xpath="//input[@name='departure']")
	WebElement DepartureDate;
	
	@FindBy(xpath="//button[@class='btn-primary btn btn-lg btn-block pfb0']")
	WebElement FlightSearchButton;
	
	@FindBy(xpath="(//a[@class='text-center'])[4]")
	WebElement CarsTab;
	
	@FindBy(xpath="//div[@id='s2id_carlocations']")
	WebElement CarsLocation;
	
	@FindBy(xpath="(//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'])[2]")
	WebElement CarsSearchButton;
	
	@FindBy(xpath="(//a[@class='text-center'])[5]")
	WebElement VisaTab;
	
	@FindBy(xpath="(//a[@class='text-center'])[3]")
	WebElement ToursTab;
	
	@FindBy(xpath="//div[@id='s2id_autogen10']")
	WebElement ToursTextbox;
	
	@FindBy(xpath="//input[@class='select2-input select2-focused']")
	WebElement CityTextbox;
	
	@FindBy(xpath="(//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'])[1]")
	WebElement TourSearchButton;
	
	@FindBy(xpath="//div[@id='s2id_autogen4']")
	WebElement FirstCountryVisa;	
	
	@FindBy(xpath="//div[@id='s2id_autogen6']")
	WebElement SecondCountryVisa;
	
	@FindBy(xpath="//button[@class='btn-primary btn btn-lg btn-block loader']")
	WebElement VisaSearchButton;
	
	@FindBy(xpath="(//div[@class='probox'])")
	WebElement OffersPlacard;
	
	@FindBy(xpath="(//div[@class='textCenter'])[2]")
	WebElement HotelPlacard;
	
	@FindBy(xpath="(//div[@class='textCenter'])[10]")
	WebElement CarsPlacard;
	
	@FindBy(xpath="(//a[text()=' Book Now'])[6]")
	WebElement TourPlacard;

	@FindBy(xpath="//i[@class='icon-right-open-3']")
	WebElement ElementClick;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Getting the Text of the DropDown(SignUp/Login)
	public String DropDownsText() {
	String text=MyAccount.getText();
	return text;
	}
	
	// Managing SignUp
	public SignUpPage Signup() {
		MyAccount.click();
		wait.SingleElementWait("(//ul[@class='dropdown-menu'])[2]");
		util.MyAccountDropDown("(//ul[@class='dropdown-menu'])[2]//li", "Sign Up");
		return new SignUpPage();
	}
	
	//Managing Login
	public LoginPage Login() {
		MyAccount.click();
		wait.SingleElementWait("(//ul[@class='dropdown-menu'])[2]");
		util.MyAccountDropDown("(//ul[@class='dropdown-menu'])[2]//li", "Login");
		return new LoginPage();
	}
	
	//Managing Currency DropDown
		public List<String> currency() {
		Actions action=new Actions(driver);
		action.moveToElement(Currency).build().perform();
		wait.SingleElementWait("//ul[contains(@style,'visibility: visible; animation-name: fadeIn; display: block;')]");
		List<String> Expected_List_Of_the_Currency_DropDown=util.DropDown("//ul[contains(@style,'visibility: visible; animation-name: fadeIn; display: block;')]//li");
		return Expected_List_Of_the_Currency_DropDown;
	}
		
	//Managing Language DropDown
		public List<String> language(){
		action.moveToElement(Language).build().perform();
		wait.SingleElementWait("//ul[contains(@style,'visibility: visible; animation-name: fadeIn; display: block;')]");
		List<String> Expected_List_Of_the_Language_DropDown=util.DropDown("//ul[contains(@style,'visibility: visible; animation-name: fadeIn; display: block;')]//li");
		return Expected_List_Of_the_Language_DropDown;
		}
		
	//Managing the Logo of the Page
		public boolean FindLogo() {
			return Logo.isDisplayed();
		}
		
	//Managing the PhoneNumber of the Page
		public boolean FindPhoneNumber() {
			return PhoneNumber.isDisplayed();
		}
		
	//Managing the Email Address of the Page
		public boolean FindEmailAddress() {
			return MailAddress.isDisplayed();
		}
		
	//Managing the Logo click of the page
		public String LogoClick() {
			Logo.click();
			wait.URL_Wait("https://www.phptravels.net/");
			String url=driver.getCurrentUrl();
			return url;
		}
		
	//Managing the HomeButton click of the page
		public String HomeButtonClick() {
			HomeButton.click();
			wait.URL_Wait("https://www.phptravels.net/");
			String url=driver.getCurrentUrl();
			return url;
		}
		
	//Managing the text of the HomeButton of the page
		public String HomeButtonText() {
			String text=HomeButton.getText();
			return text;
		}
		
	//Managing the BlogButton click of the page
		public BlogPage BlogButtonClick() {
			BlogButton.click();
			wait.URL_Wait("https://www.phptravels.net/blog");
			return new BlogPage();
		}
		
	//Managing the text of the BlogButton of the page
		public String BlogButtonText() {
			String text=BlogButton.getText();
			return text;
		}

	//Managing the OffersButton click of the page
		public OffersPage OffersButtonClick() {
			OffersButton.click();
			wait.URL_Wait("https://www.phptravels.net/offers");
			return new OffersPage();
		}
				
	//Managing the text of the OffersButton of the page
		public String OffersButtonText() {
			String text=OffersButton.getText();
			return text;
		}
		
	
	//Managing Hotels of the page
		public HotelsPage Hotelbooking() {
		HotelsTab.click();
		HotelsSearchbar.sendKeys("fra");
		wait.SingleElementWait("//ul[@class='select2-result-sub']");
		util.MyAccountDropDown("//ul[@class='select2-result-sub']/li", "Francisco Beltrao, Brazil");
		String currentdate=util.Current_Date();
		String pastdate=util.Past_Current_Date();
		HotelsCheckinDate.sendKeys(currentdate);
		HotelsCheckOutDate.sendKeys(pastdate);
		HotelSearchButton.click();
		return new HotelsPage();
		}
		
	//Managing One Way Flight
		/*public FlightPage OneWayFlightBooking() {
		FlightsTab.click();
		wait.SingleElementWait("(//span[text()='Enter City Or Airport'])[1]");
		DepartingAirport.click();
		DepartingAirportTextBox.sendKeys("IND");
		wait.SingleElementWait("(//UL[@class='select2-results'])[9]");
		util.MyAccountDropDown("//ul[@class='select2-results']/li/div", "Clorinda Airport (CLX)");
		
		DepartingAirport.click();
		DepartingAirportTextBox.sendKeys("IND");
		wait.SingleElementWait("(//UL[@class='select2-results'])[9]");
		util.MyAccountDropDown("//ul[@class='select2-results']/li/div", "Monroe Cty Arpt Indiana (BMG)");
		FlightSearchButton.click();
		String currentdate=util.Current_Date2();
		DepartureDate.sendKeys(currentdate);
		ElementClick.click();
		FlightSearchButton.click();
		return new FlightPage();		
		}*/
		
	//Managing Cars of the page
		public CarsPage CarBooking() {
		CarsTab.click();
		wait.SingleElementWait("//div[@id='s2id_carlocations']");
		CarsLocation.click();
		util.MyAccountDropDown("//ul[@class='select2-results']/li/div", "Manchester");
		wait.SingleElementWait("//div[@id='s2id_carlocations2']/a/span[text()='Manchester']");
		CarsSearchButton.click();
		return new CarsPage();
		}
	
	//Managing Visa of the page
		public void VisaBooking() {
		VisaTab.click();
		wait.SingleElementWait("//div[@id='s2id_autogen4']");
		FirstCountryVisa.click();
		util.MyAccountDropDown("//ul[@class='select2-results']/li/div", "Argentina");
		
		SecondCountryVisa.click();
		util.MyAccountDropDown("//ul[@class='select2-results']/li/div", "American Samoa");
		VisaSearchButton.click();
		}
		
	//Managing Tours of the page
		public TourPage TourBooking() {
		ToursTab.click();
		wait.SingleElementWait("//span[text()='Search by Listing or City Name']");
		ToursTextbox.click();
		CityTextbox.sendKeys("Hong");
		util.MyAccountDropDown("//ul[@class='select2-results']/li/ul", "Hong Kong Island Tour");
		TourSearchButton.click();
		return new TourPage();
		}
		
	//Managing the offers placards on the homepage
		public boolean offers_placards() {
		boolean displayofelements=false;
		List<WebElement> element=driver.findElements(By.xpath("(//div[@class='probox'])"));
		for(int i=1;i<=element.size()-4;i++) {
		driver.findElement(By.xpath("(//div[@class='probox'])["+i+"]")).click();
		driver.navigate().back();
		displayofelements=OffersPlacard.isDisplayed();
		}
		return displayofelements;
		}

	//Managing the hotel placard on the homepage
		public HotelBookingPage hotel_placards() {
		HotelPlacard.click();
		return new HotelBookingPage();
		}
		
	//Managing the Cars placard on the homepage
		public CarsBookingPage cars_placards() {
		CarsPlacard.click();
		return new CarsBookingPage();
		}
		
	//Managing the Tour placard on the homepage
		public TourBookingPage tour_placards() {
		TourPlacard.click();
		return new TourBookingPage();
		}
			
}

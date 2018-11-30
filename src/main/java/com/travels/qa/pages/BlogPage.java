package com.travels.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.qa.base.TestBase;
import com.travels.qa.common.TestLists;
import com.travels.qa.common.TestWait;
import com.travels.qa.utility.Testutility;

public class BlogPage extends TestBase {

	Testutility util = new Testutility();
	TestWait wait = new TestWait();
	TestLists lists = new TestLists();
	HomePage homepage = new HomePage();

	@FindBy(xpath = "//input[@name='s']")
	WebElement SearchBar;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement SearchButton;

	@FindBy(xpath = "//div[@class='col-md-8']")
	WebElement AllElementsOfthePage;

	@FindBy(xpath = "//div[@class='panel-body']//h1[text()='No Results Found']")
	WebElement NoElementsFoundonPage;

	public BlogPage() {
		PageFactory.initElements(driver, this);
	}

	// Managing the Content of the Page
	public boolean ManagingContent() {
		boolean displayofelements=false;
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='col-md-8']/a/h4"));
		for (int j = 2; j < 5; j++) {
			for (int i = 1; i < element.size() + 1; i++) {
				displayofelements = AllElementsOfthePage.isDisplayed();
				driver.findElement(By.xpath("(//div[@class='col-md-8']/a/h4)[" + i + "]")).click();
				driver.navigate().back();
			}
			driver.findElement(By.xpath("(//a[@href='https://www.phptravels.net/blog/listing/" + j + "'])[2]")).click();
		}
		return displayofelements;
	}

	// Managing the searchBar to get content
	public boolean Content_through_searchBar() {
		SearchBar.sendKeys("travel");
		SearchButton.click();
		wait.SingleElementWait("//div[@class='col-md-8']");
		boolean displayofelement = AllElementsOfthePage.isDisplayed();
		return displayofelement;
	}

	// Managing the searchBar if the content is not available
	public boolean NoContent_through_searchBar() {
		SearchBar.sendKeys("qwerty");
		SearchButton.click();
		boolean displayofnoelement = NoElementsFoundonPage.isDisplayed();
		return displayofnoelement;
	}

	// Managing the side menu of the Blog page
	public boolean side_menu_option() {
		boolean displayofelement = false;
		List<WebElement> element = driver.findElements(By.xpath("(//a[@class='list-group-item'])"));
		for (int i = 1; i < element.size() + 1; i++) {
		driver.findElement(By.xpath("(//a[@class='list-group-item'])[" + i + "]")).click();
		displayofelement = AllElementsOfthePage.isDisplayed();
		}
		return displayofelement;
	}
}

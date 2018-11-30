package com.travels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travels.qa.base.TestBase;
import com.travels.qa.pages.BlogPage;
import com.travels.qa.pages.HomePage;
import com.travels.qa.utility.Testutility;

public class Blog_Testcase extends TestBase {

	HomePage homepage;
	Testutility utility;
	BlogPage blog;

	public Blog_Testcase() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		utility = new Testutility();
		blog=new BlogPage();
	}
	
	//Verifying the presence of Content on the Blog Page TC #1
	@Test
	public void Content_on_the_page() {
	test=extent.createTest("Content_on_the_page");
	homepage.BlogButtonClick();
	boolean result=blog.ManagingContent();
	Assert.assertTrue(result);
	}

	//Verifying the presence of Content when Searched through the SearchBar TC #2
	@Test
	public void Content_through_searchbar() {
	test=extent.createTest("Content_through_searchbar");
	homepage.BlogButtonClick();
	boolean result=blog.Content_through_searchBar();
	Assert.assertTrue(result);
	}
	
	//Verifying no Content is displayed when Searched through the SearchBar TC #3
	@Test
	public void No_Content_through_searchbar() {
	test=extent.createTest("No_Content_through_searchbar");
	homepage.BlogButtonClick();
	boolean result=blog.NoContent_through_searchBar();
	Assert.assertTrue(result);
	}

	//Verifying The SideMenu of the Blog page TC #4
	@Test
	public void Side_menu_of_blog() {
	test=extent.createTest("Side_menu_of_blog");
	homepage.BlogButtonClick();
	boolean result=blog.side_menu_option();
	Assert.assertTrue(result);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

package com.travels.qa.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.travels.qa.base.TestBase;

public class TestWait extends TestBase {

	WebDriverWait elementwait = new WebDriverWait(driver, 40);
	
	public void SingleElementWait(String userxpath) {
		elementwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userxpath)));
	}
	
	
	public void URL_Wait(String url) {
		elementwait.until(ExpectedConditions.urlToBe(url));
	}
	
	public void TextToBe_Wait(String url, String value) {
		elementwait.until(ExpectedConditions.textToBe(By.xpath(url), value));
	}
	
	public void VisibilityOfAllElements(List<WebElement> element) {
		elementwait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
}

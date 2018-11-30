package com.travels.qa.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.travels.qa.base.TestBase;

public class Testutility extends TestBase {

	public static long PAGE_LOADING_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT = 20;

	public void MyAccountDropDown(String listxpath, String text) {

		List<WebElement> list = driver.findElements(By.xpath(listxpath));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(text)) {
				list.get(i).click();
				break;
			}
		}
	}
	
	public List<String> DropDown(String listxpath) {
		List<WebElement> list=driver.findElements(By.xpath(listxpath));
		 List<String> ExpectedListValuesOfCurrency=new ArrayList<String>();
		 for(int i=0;i<list.size();i++) {
			 ExpectedListValuesOfCurrency.add(list.get(i).getText());
		 }
		return ExpectedListValuesOfCurrency;
	}
	
	
	public String Current_Date() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 return date1;
	}
	
	public String Current_Date2() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 return date1;
	}
	
	public String Past_Current_Date() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 4);
	    String newDate = dateFormat.format(cal.getTime());
	    return newDate;
	}	
	
	public String Past_Current_Date2() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 7);
	    String newDate = dateFormat.format(cal.getTime());
	    return newDate;
	}
	
	public void DropDowns(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
}

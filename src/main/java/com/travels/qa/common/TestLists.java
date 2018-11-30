package com.travels.qa.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.travels.qa.base.TestBase;

public class TestLists extends TestBase {

	//List to match HomePage Currency
	public List<String> Currency_Suggestions() {
		
		List<String> ActualListValuesOfCurrency=new ArrayList<String>();
	     ActualListValuesOfCurrency.add("USD");
	     ActualListValuesOfCurrency.add("GBP");
	     ActualListValuesOfCurrency.add("SAR");
	     ActualListValuesOfCurrency.add("EUR");
	     ActualListValuesOfCurrency.add("PKR");
	     ActualListValuesOfCurrency.add("KWD");
	     ActualListValuesOfCurrency.add("JPY");
	     ActualListValuesOfCurrency.add("INR");
	     ActualListValuesOfCurrency.add("CNY");
	     ActualListValuesOfCurrency.add("TRY");

	     return ActualListValuesOfCurrency;
	}
	
	//List to match HomePage Language
	public List<String> Language_Suggestions(){
		
		List<String> ActualListValuesOfLanguages=new ArrayList<String>();
		ActualListValuesOfLanguages.add("Farsi");
		ActualListValuesOfLanguages.add("Arabic");
		ActualListValuesOfLanguages.add("Turkish");
		ActualListValuesOfLanguages.add("French");
		ActualListValuesOfLanguages.add("Spanish");
		ActualListValuesOfLanguages.add("Russian");
		ActualListValuesOfLanguages.add("English");
		return ActualListValuesOfLanguages;
	}
	
	//List to match Error messages on the SignUp Page when no field has been entered
	public List<String> Signup_button_click_without_any_field_entered(){
	
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}
	
	//List to match Error messages on the SignUp Page when FirstName has been entered
	public List<String> Signup_button_click_when_FirstName_field_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}

	//List to match Error messages on the SignUp Page when FirstName has been entered
	public List<String> Signup_button_click_when_LastName_field_entered(){
			
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The First name field is required.");
		return ActualListValuesOfErrors;
	}

	//List to match Error messages on the SignUp Page when Email has been entered
	public List<String> Signup_button_click_when_Email_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}
	
	//List to match Error messages on the SignUp Page when Password has been entered
	public List<String> Signup_button_click_when_Password_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}
	
	//List to match Error messages on the SignUp Page when ConfirmPassword has been entered
	public List<String> Signup_button_click_when_ConfirmPassword_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The Password field is required.");
		ActualListValuesOfErrors.add("Password not matching with confirm password.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}
	
	//List to match Error messages on the SignUp Page when mismatched ConfirmPassword and Password has been entered
	public List<String> Signup_button_click_when_mismatched_Password_and_ConfirmPassword_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("Password not matching with confirm password.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}

	//List to match Error messages on the SignUp Page when mismatched ConfirmPassword and Password has been entered
	public List<String> Signup_button_click_when_matched_Password_and_ConfirmPassword_entered(){
		
		List<String> ActualListValuesOfErrors=new ArrayList<String>();
		ActualListValuesOfErrors.add("The Email field is required.");
		ActualListValuesOfErrors.add("The First name field is required.");
		ActualListValuesOfErrors.add("The Last Name field is required.");
		return ActualListValuesOfErrors;
	}
}

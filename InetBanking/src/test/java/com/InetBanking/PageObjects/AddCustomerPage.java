package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
				
			}

@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
@CacheLookup
WebElement AddNewCustomer;

@FindBy(how=How.NAME, using="name")
@CacheLookup
WebElement CustomerName;

@FindBy(how=How.NAME, using="rad1")
@CacheLookup
WebElement CustomerGender;

@FindBy(how=How.ID_OR_NAME, using="dob")
@CacheLookup
WebElement CustomerDOB;

@FindBy(how=How.NAME, using="addr")
@CacheLookup
WebElement CustomerAddress;

@FindBy(how=How.NAME, using="city")
@CacheLookup
WebElement CustomerCity;

@FindBy(how=How.NAME, using="state")
@CacheLookup
WebElement CustomerState;

@FindBy(how=How.NAME, using="pinno")
@CacheLookup
WebElement CustomerPIN;

@FindBy(how=How.NAME, using="telephoneno")
@CacheLookup
WebElement CustomerMobile;


@FindBy(how=How.NAME, using="emailid")
@CacheLookup
WebElement CustomerEmail;

@FindBy(how=How.NAME, using="password")
@CacheLookup
WebElement CustomerPassword;

@FindBy(how=How.NAME, using="sub")
@CacheLookup
WebElement CustomerSubmit;


public void ClickAddNewCustomer() {
	
	AddNewCustomer.click();
}

public void SetCustomername(String cutomername) {
	
	CustomerName.sendKeys(cutomername);
}
public void SetCustomerGender() {
	
	
CustomerGender.click();
}


public void SetCustomerdob(String mm, String dd, String yy) {
	CustomerDOB.click();
	CustomerDOB.sendKeys(mm);
	CustomerDOB.sendKeys(dd);
	CustomerDOB.sendKeys(yy);
}
public void SetCustomeraddress(String address) {
	
	CustomerAddress.sendKeys(address);;
}

public void SetCustomercity(String city) {
	
	CustomerCity.sendKeys(city);
}
public void SetCustomerstate(String state) {//these are action methods
	
	CustomerState.sendKeys(state);
}

public void SetCustomerpin(String pin) {
	
	CustomerPIN.sendKeys(String.valueOf(pin));
}
public void SetCustomertelephone(String telephone) {
	
	CustomerMobile.sendKeys(telephone);
}
public void SetCustomeremail(String email) {
	
	CustomerEmail.sendKeys(email);
}
public void SetCustomerpassword(String password) {
	
	CustomerPassword.sendKeys(password);
}

public void Customersubmit() {
	
	CustomerSubmit.click();
}







}

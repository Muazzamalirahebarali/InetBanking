package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
				
			}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement lpusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement lppassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement ButtonLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement LinkLogout;
	
	public void SetUsername(String username) {
		
		lpusername.sendKeys(username);
	}
	
public void SetPassword(String password) {
		
	lppassword.sendKeys(password);
	}
	
public void clickLoginButton() {
	ButtonLogin.click();
}

public void clickLogout() {
	LinkLogout.click();
}
	
}

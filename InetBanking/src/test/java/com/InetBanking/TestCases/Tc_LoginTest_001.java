package com.InetBanking.TestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;

public class Tc_LoginTest_001 extends TestBase {

	
	
	
	@Test
	public void IsLogedIn() throws IOException {
		
		
		LoginPage lpObject=new LoginPage(driver);
		logger.info("userName Entered");
		lpObject.SetUsername(Tbusername);
		
		logger.info("password Entered");
		lpObject.SetPassword(Tbpassword);
		
		lpObject.clickLoginButton();
		logger.info("======Clicked on Submit==========");
		
				
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("Login Test Passed");
			Assert.assertTrue(true);
			
		}
		else {
			CaptureScreen(driver,"IsLogedIn");
			logger.info("Login Test FAILED");
			Assert.assertFalse(false);
			
			
			
	
		}
	}
	
	
}

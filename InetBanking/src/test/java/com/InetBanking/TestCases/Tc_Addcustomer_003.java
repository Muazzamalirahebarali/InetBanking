package com.InetBanking.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;
import com.InetBanking.PageObjects.LoginPage;

import junit.framework.Assert;

public class Tc_Addcustomer_003 extends TestBase {
	
	
	@Test
	public void addNewCutomer() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsername(Tbusername);
		logger.info("Username Entered");
		
		lp.SetPassword(Tbpassword);
		logger.info("Password Entered");
		
		lp.clickLoginButton();
		logger.info("Liogin Button Clicked");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcustomer=new AddCustomerPage(driver);
		
		addcustomer.ClickAddNewCustomer();
		logger.info("Adding new Customer details");
		
		addcustomer.SetCustomername("Russle");
		addcustomer.SetCustomerGender();
		addcustomer.SetCustomerdob("11","11","1985");
						Thread.sleep(3000);
		addcustomer.SetCustomeraddress("Ganpati mata mandir warje pune 151215");
		addcustomer.SetCustomercity("Pune");
		addcustomer.SetCustomerstate("Maha");
		addcustomer.SetCustomerpin("411057");
		addcustomer.SetCustomertelephone("879641545445");
		String email=randomString()+"@gmail.com";
		addcustomer.SetCustomeremail(email);
		System.out.println(email);
		logger.info("Random Email is Entered");
		
		addcustomer.SetCustomerpassword("truck123");
		addcustomer.Customersubmit();
		logger.info("New customer Details are submitted");
		boolean response=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(response==true) {
			Assert.assertTrue(true);
			logger.info("customer Added Successfully");
		}
		else
		{
			CaptureScreen(driver,"addNewCutomer");
			Assert.assertTrue(false);
			logger.info("customer Added Successfully");
		}
	}
	
}

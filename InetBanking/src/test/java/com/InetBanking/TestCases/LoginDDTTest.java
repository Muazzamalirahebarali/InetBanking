package com.InetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;
import com.InetBanking.Utilities.XLUtils;

public class LoginDDTTest extends TestBase {
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String username, String password) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.clickLoginButton();
		Thread.sleep(3000);
		
		if(isalertpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Thread.sleep(3000);
		}
		else
		{
			lp.clickLoginButton();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		
		
	}
	public boolean isalertpresent() {
		driver.switchTo().alert().accept();
		return true;
	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException{
		
		String xlpath=System.getProperty("user.dir")+"./src/TesData/LoginData.xlsx";
		
		
			int rowcount=XLUtils.getRowCount(xlpath, "Sheet1");
			int colcount=XLUtils.getCellCount(xlpath, "Sheet1",1);
			
			String logindata[][]=new String[rowcount][colcount];
			
			for(int i=1; i<rowcount; i++) {
				for(int j=0; j<colcount; j++) {
					logindata[i-1][j]=XLUtils.getCellData(xlpath, "Sheet1", i, j);
				}
			}
			
		return logindata;
		
	}
	

}

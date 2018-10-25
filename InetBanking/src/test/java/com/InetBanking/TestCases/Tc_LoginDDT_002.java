package com.InetBanking.TestCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;
import com.InetBanking.Utilities.XLUtils;

public class Tc_LoginDDT_002 extends TestBase
{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsername(user);
		lp.SetPassword(pwd);
						
		lp.clickLoginButton();
		logger.info("Clicked on LoginButton");  
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) //Fail TestCase
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
			Thread.sleep(3000);
		}
		else
		{
			Assert.assertTrue(true);//Passed TestCase
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close the alert box of Logout button.
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			
		}
		
}
	
	public boolean isAlertPresent() 
	{
		try {
			
		driver.switchTo().alert();
		
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
		
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		
		String path=System.getProperty("user.dir")+"/src/test/java/Com/InetBanking/TestData/LoginData.ods";
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%"+path);

		int rowcount=XLUtils.getRowCount(path,"sheet1");
		int colcount=XLUtils.getCellCount(path,"sheet1",1);

		
		String logindata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<rowcount;i++) //Reading from Excel from first cell
		{
			for(int j=0;j<colcount;j++)//reading from zeroth row
			{
				
				logindata[i-1][j]=XLUtils.getCellData(path,"sheet1",i,j);//this code will capture data from excel
			
			}
		}
		return logindata;		
				
}

}

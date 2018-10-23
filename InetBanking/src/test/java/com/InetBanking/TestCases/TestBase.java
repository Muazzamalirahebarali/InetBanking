package com.InetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBanking.Utilities.ReadConfig;

public class TestBase {

	ReadConfig readconfig=new ReadConfig();
	
	public String BaseURL=readconfig.getApplicationURL();
	public String Tbusername=readconfig.getUsername();
	public String Tbpassword=readconfig.getPassword();
	
	WebDriver driver;
	
	public static Logger logger;//adding logs
@Parameters("Browser")
@BeforeClass
	public void Setup(String br)
{
	
	logger=Logger.getLogger("InetBanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("Chrome"))
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	driver=new ChromeDriver();
	}
	
	else if(br.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver=new FirefoxDriver();
	}
	logger.info("=======Bank URL is called=========");
	driver.get(BaseURL);
	
	driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);

	}
	
		
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	public void CaptureScreen(WebDriver driver,String testname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir")+"/Screenshot/"+testname+".png");
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot Taken");
		
	}
	
	public static String randomString() {
		String generatestring1=RandomStringUtils.randomAlphabetic(8);
		return (generatestring1);
	}

}

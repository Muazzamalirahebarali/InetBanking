package com.InetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro;
	
	public ReadConfig()//CREATE a Constructor
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);//Read mode
			pro= new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String URL=pro.getProperty("BaseURL");
		return URL;
		
	}
	public String getChromePath() {
		String chromepath=pro.getProperty("Chromepath");
		return chromepath;
		
	}
	
	public String getFirefoxPath() {
		String firefoxpath=pro.getProperty("Firefoxpath");
		return firefoxpath;
		
	}
	
	public String getUsername() {
		String username=pro.getProperty("Configusername");
		return username;
		
	}
	public String getPassword() {
		String password=pro.getProperty("Configpassword");
		return password;
		
	}
	public String getTransporterUsername() {
		String username=pro.getProperty("ConfigTransporterusername");
		return username;
		
	}
	public String getTransporterPassword() {
		String password=pro.getProperty("ConfigTransporterpassword");
		return password;
		
	}
	
}

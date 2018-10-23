package com.InetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro;
	
	public ReadConfig() {
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
	public String getUsername() {
		String username=pro.getProperty("Configusername");
		return username;
		
	}
	public String getPassword() {
		String password=pro.getProperty("Configpassword");
		return password;
		
	}
	
	public String getChromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getFirefoxPath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
	
}

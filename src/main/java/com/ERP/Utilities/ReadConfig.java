package com.ERP.Utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties properties;
	String Path = "C:\\Eclipse Workspace\\PGWebsitesAutomation\\ERP\\Configuration\\config.properties";
	
	public ReadConfig()
	{
		try {
	    	properties = new Properties();
		
			FileInputStream fis = new FileInputStream(Path);
			properties.load(fis);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
			
			else
				throw new RuntimeException("url is not specified in cofigued file");
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
		return value;
		
		else
			throw new RuntimeException("url is not specified in cofigued file");
	}
}

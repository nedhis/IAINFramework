 package com.mma.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider()
	{
		File file=new File("./ConfigurationFile/Config.properties");
		
			try {
				FileInputStream fis=new FileInputStream(file);
				prop=new Properties();
				prop.load(fis);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
	}
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("TestURL");
	}
   
	public String dataFromConfig(String keyToSearch)
	{
		return prop.getProperty("keyToSearch");
	}
}

package com.commerce.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig() 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("./Configuration\\configure.properties");
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		} 
	}

	public String getURL()
	{
		String URL = pro.getProperty("URL");
		return URL;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
}

package com.commerce.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.commerce.utilities.ReadConfig;

public class Base
{
	public static WebDriver driver;
	public static Logger logger;
	
	ReadConfig rc= new ReadConfig();
	public String URL = rc.getURL();
	public String email = rc.getEmail();
	public String password = rc.getPassword();
	
	@SuppressWarnings("deprecation")
	@Parameters ("browser")
	@BeforeClass
	public void driverSetting(String br)
	{
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + rc.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + rc.getFirefoxPath());
		driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + rc.getEdgePath());
		driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("E-Commerce");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	public void captureScreen(String tname) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			
		try 
		{
			FileHandler.copy(source,target);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Screenshot Captured");
	}
	
	public String randomCharacter()
	{
		String alphabet = RandomStringUtils.randomAlphabetic(5);
		return alphabet;
	}
}

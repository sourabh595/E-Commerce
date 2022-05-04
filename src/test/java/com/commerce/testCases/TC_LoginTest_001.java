package com.commerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base
{
	@Test
	public void loginTest()
	{
		driver.get(URL);
		logger.info("URL opened....");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(email);
		logger.info("Email inserted");
		lp.setPassword(password);
		logger.info("Password inserted");
		lp.clickBtnLogin();
		logger.info("Login button clicked");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Login Successfull");
			lp.clickBtnLogout();
			logger.info("Logout Successfull");
		}
		else
		{
			try
			{
				captureScreen("loginTest");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			Assert.assertTrue(false,"Login Failed");
			logger.info("Login Failed");
		}
	 }
}

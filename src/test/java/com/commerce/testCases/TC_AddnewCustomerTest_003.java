package com.commerce.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commerce.pageObjects.AddnewCustomerPage;
import com.commerce.pageObjects.LoginPage;

public class TC_AddnewCustomerTest_003 extends Base
{
	@Test
	public void addNewCustomerTest() throws Exception
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
		
		AddnewCustomerPage ancp = new AddnewCustomerPage(driver);
		ancp.clickCustomer();
		ancp.clickListCustomer();
		ancp.clickAddNew();
		logger.info("Add new Button clicked successfully");
		ancp.setEmail(randomCharacter()+"@gmail.com");
		logger.info("Email inserted");
		ancp.setPassword("testing");
		logger.info("Password inserted");
		ancp.setFirstName("Subhash Kumar");
		logger.info("FName inserted");
		ancp.setLastName("Patel");
		logger.info("LName inserted");
		Thread.sleep(10000);
		ancp.setGender("Male");
		logger.info("Gender selected");
		ancp.setDOB("11/01/1999");
		logger.info("DOB inserted");
		ancp.setCompany("Infosys");
		logger.info("Company inserted");
		ancp.clickIsTaxExempt();
		Thread.sleep(10000);
		ancp.setNewsLetter("Your Store Name");
		logger.info("Selected store");
		/*Thread.sleep(10000);
		ancp.setCustomerRole("Registered");*/
		logger.info("Selected customer role");
		Thread.sleep(10000);
		ancp.setVendor("Not A Vendor");
		ancp.setAdminComment("Thanks for Registering");
		logger.info("Comment inserted");
		ancp.clickSave();
		logger.info("Clicked Save Button");
		
		if(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."))
		{
			Assert.assertTrue(true);
			logger.info("Customer Added Successfully");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen("TC_AddnewCustomerTest_003");
		}	
	}
}

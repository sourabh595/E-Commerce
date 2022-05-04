package com.commerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver lDriver;
	public LoginPage(WebDriver rDriver) 
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement txtUserName;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	WebElement btnLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickBtnLogin()
	{
		btnLogin.click();
	}
	
	public void clickBtnLogout()
	{
		btnLogout.click();
	}
}

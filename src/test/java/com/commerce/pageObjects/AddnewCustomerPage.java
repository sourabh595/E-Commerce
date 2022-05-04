package com.commerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddnewCustomerPage
{
	WebDriver ldriver;
	public AddnewCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")
	WebElement btnCustomer;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement btnListCustomer;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement btnAddNew;
	
	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(id = "FirstName")
	WebElement txtFirstName;
	
	@FindBy(id = "LastName")
	WebElement txtLastName;
	
	@FindBy(id = "Gender_Male")
	WebElement rdMale;
	
	@FindBy(id = "Gender_Female")
	WebElement rdFemale;
	
	@FindBy(id = "DateOfBirth")
	WebElement txtDOB;
	
	@FindBy(id = "Company")
	WebElement txtCompany;
	
	@FindBy(id = "IsTaxExempt")
	WebElement cbIsTaxExempt;
	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div")
	WebElement ddNewsLetter;
	
	@FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/ul[1]/li[1]")
	WebElement nlYourStoreName;
	
	@FindBy(xpath = "//li[contains(text(),'Test store 2')]")
	WebElement nlTestStore2;
	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div")
	WebElement ddCustomerRole;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
	WebElement crAdministrators;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")
	WebElement crForumModerators;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
	WebElement crGuests;
	
	@FindBy(xpath = "//*[@id=\"4127eabe-164c-450b-80a6-b94c488de2d4\"]")
	WebElement crRegistered;
	
	@FindBy(xpath = "//*[@id=\"4127eabe-164c-450b-80a6-b94c488de2d4\"]")
	WebElement crVendors;
	
	@FindBy(id = "VendorId")
	WebElement ddVendorId;
	
	@FindBy(id = "AdminComment")
	WebElement txtAdminComment;
	
	@FindBy(name = "save")
	WebElement btnSave;
	
	public void clickCustomer()
	{
		btnCustomer.click();
	}
	
	public void clickListCustomer()
	{
		btnListCustomer.click();
	}
	
	public void clickAddNew()
	{
		btnAddNew.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setGender(String gender) 
	{
		if (gender.equals("Male"))
		{
			rdMale.click();
		}
		else if (gender.equals("Female")) 
		{
			rdFemale.click();
		}
		else 
		{
			rdMale.click();
		}
	}
	
	public void setDOB(String dob)
	{
		txtDOB.sendKeys(dob);
	}
	
	public void setCompany(String co)
	{
		txtCompany.sendKeys(co);
	}
	
	public void clickIsTaxExempt()
	{
		cbIsTaxExempt.click();
	}
	
	public void setNewsLetter(String newsl)
	{
		ddNewsLetter.click();
		
		WebElement weclick;
		switch (newsl) 
		{
		case "Your Store Name": weclick=nlYourStoreName;break;
		case "Test Store 2": weclick=nlTestStore2;break;
		default:weclick=nlYourStoreName;
		}
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", weclick);
	}
	
	public void setCustomerRole(String role)
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		ddCustomerRole.click();
		
		WebElement weclick;
		switch (role) 
		{
		case "Administrators":weclick = crAdministrators;break;
		case "Forum Moderators":weclick = crForumModerators;break;
		case "Guests":weclick = crGuests;break;
		case "Registered":weclick = crRegistered;break;
		case "Vendors":weclick = crVendors;break;
		default:weclick = crGuests;
		}
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", weclick);
	}
	
	public void setVendor(String vd)
	{
		switch (vd)
		{
		case "Not A Vendor": new Select(ddVendorId).selectByVisibleText("Not a vendor");break;
		case "Vendor 1": new Select(ddVendorId).selectByVisibleText("Vendor 1");break;
		case "Vendor 2": new Select(ddVendorId).selectByVisibleText("Vendor 2");break;
		default: new Select(ddVendorId).selectByVisibleText("Not a vendor");
		}
	}
	
	public void setAdminComment(String ac)
	{
		txtAdminComment.sendKeys(ac);
	}
	
	public void clickSave()
	{
		btnSave.click();
	}
}

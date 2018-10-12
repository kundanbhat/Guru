package com.Guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.base.TestBase;

public class ManagerPage extends TestBase 
{
	
	@FindBy(xpath="//td[contains(text(),'Manger Id : mngr26593')]")
	WebElement mangerNameLabel;
	
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	WebElement addNewCustomerLink;
	
	
	
	
	
	public ManagerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateMangerId()
	{
		return mangerNameLabel.getText();
	}
	public AddNewCustomerPage clickOnAddNewCustomerPage()
	{
		addNewCustomerLink.click();
		return new AddNewCustomerPage();
	}
	
	
	
}

package com.Guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userName;
	
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passWord;
	
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement loginButton;
	
	
	@FindBy(xpath="//img[@alt='Guru99 Demo Sites']")
	WebElement logoImage;
	
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return   driver.getTitle();
	}
	public boolean verifyLogoImage()
	{
		return logoImage.isDisplayed();
	}
	
	public ManagerPage login(String userName,String passWord)
	{
	   this.userName.sendKeys(userName);
	   this.passWord.sendKeys(passWord);
	   loginButton.click();
	   return new ManagerPage();
		
	}
	
	
	
	
	

}

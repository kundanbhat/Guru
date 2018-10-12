package com.Guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.base.TestBase;
import com.Guru99.pages.LoginPage;
import com.Guru99.pages.ManagerPage;

public class LoginPageTestCases extends TestBase{
	
	
	LoginPage loginPage;
	ManagerPage managerPage;
	
	
	 public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test
	public void LoginPageTitleTest()
	{
		String title= loginPage.validateTitle();
		Assert.assertEquals(title.trim(), "Guru99 Bank Home Page");
	}
	@Test
	public void LoginPageLogoTest()
	{
		boolean isDisplayed= loginPage.verifyLogoImage();
		Assert.assertEquals(isDisplayed, true);
	}
	@Test
	public void LoginPageLoginTest() throws InterruptedException
	{
		managerPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

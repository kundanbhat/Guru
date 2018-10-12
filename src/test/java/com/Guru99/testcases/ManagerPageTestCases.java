package com.Guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.base.TestBase;
import com.Guru99.pages.LoginPage;
import com.Guru99.pages.ManagerPage;

public class ManagerPageTestCases extends TestBase{
	
	ManagerPage managerPage;
	LoginPage loginPage;
	
	public ManagerPageTestCases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerPage=new ManagerPage();
		loginPage=new LoginPage();
		managerPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void testManagerId()
	{
		String managerId=managerPage.validateMangerId();
		Assert.assertEquals(managerId, "Manger Id : mngr26593");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}

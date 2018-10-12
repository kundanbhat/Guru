package com.Guru99.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99.base.TestBase;
import com.Guru99.pages.AddNewCustomerPage;
import com.Guru99.pages.LoginPage;
import com.Guru99.pages.ManagerPage;
import com.Guru99.util.Result;
import com.Guru99.util.Util;



public class AddNewCustomerTestCases extends TestBase{
	
	
	
	LoginPage loginPage;
	AddNewCustomerPage newCustomerPage;
	ManagerPage managerPage;
	
	public AddNewCustomerTestCases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		loginPage=new LoginPage();
		managerPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newCustomerPage=managerPage.clickOnAddNewCustomerPage();
	}
	
	@Test(dataProvider="getCustomerData")
	public void addNewCustomer(String customerName,String gender,String date,String address,String city,String state,String pincode,String mobile,String emailId,String password)
	{
		try
		{
		  Result result=newCustomerPage.createNewCustomer(customerName,gender, date, address, city, state, pincode, mobile, emailId, password);
		  Assert.assertTrue(result.success, result.message);
			
		}
		catch(Exception ex) {ex.printStackTrace();Assert.assertTrue(false);}
	}
	
	@DataProvider
	public Object[][] getCustomerData(){
		Object data[][] = Util.getTestData("Sheet1");
		return data;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		
		driver.quit();
	}

}

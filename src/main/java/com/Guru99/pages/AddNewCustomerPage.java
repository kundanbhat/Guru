package com.Guru99.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.base.TestBase;
import com.Guru99.util.Result;

public class AddNewCustomerPage extends TestBase{
	
	LoginPage loginPage;
	
	
	
	@FindBy(xpath="//input[@name='name']")
	WebElement customerName;
	
	
	@FindBy(xpath="//input[@value='m']")
	WebElement maleRadioButton;
	
	
	@FindBy(xpath="//input[@value='f']")
	WebElement femaleRadioButton;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement telephone;
	
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailId;
	
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitButton;
	
	@FindBy(xpath="//p[contains(text(),'Customer Registered Successfully!!!')]")
	WebElement successfullRegistered;
	
	
	public AddNewCustomerPage()
	{
		PageFactory.initElements(driver, this);
		loginPage=new LoginPage();
	}
	public Result createNewCustomer(String customerName,String gender,String date,String address,String city,String state,String pin,String telephone,String emailId,String password)
	{
		this.customerName.sendKeys(customerName);
		
		if(gender.equalsIgnoreCase("m"))
			maleRadioButton.click();
		else if(gender.equalsIgnoreCase("f"))
			maleRadioButton.click();
		//selectDatebyJs(driver, driver.findElement(By.xpath("//input[@name='dob']")), date);
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(date);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.pin.sendKeys(pin);
		this.telephone.sendKeys(telephone);
		this.emailId.sendKeys(emailId);
		this.password.sendKeys(password);
		submitButton.click();
		
		
		boolean success=false;
		boolean isAlertExist=false;
		Result result=new Result();
		try
		{
			Alert alert=driver.switchTo().alert();
			result.success=false;
			result.message=alert.getText();
			alert.accept();
			isAlertExist=true;
		}
		catch(org.openqa.selenium.NoAlertPresentException ecc) {}
		if(!isAlertExist)
		{
			try
			{
				 success= successfullRegistered.isDisplayed();
			}
			catch(org.openqa.selenium.NoSuchElementException ex) {}
		}
		
		if(success)
		{
			
			result.success=true;
			result.message="success";
		}
		else
		{
			
		}
		return result;
					
	}
	
	public static void selectDatebyJs(WebDriver driver,WebElement webElement,String dateVal)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",webElement);
		
		
		
		
	}

}

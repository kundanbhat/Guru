package com.Guru99.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		prop=new Properties();
		FileInputStream fin;
		try {
			fin = new FileInputStream("src\\main\\java\\com\\Guru99\\config\\config.properties");
			prop.load(fin);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("FFdriverExePath"));
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	






}

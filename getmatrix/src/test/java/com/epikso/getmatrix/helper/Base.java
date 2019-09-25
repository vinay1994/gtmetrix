package com.epikso.getmatrix.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.epikaso.getmatrix.config.Constants;
import com.epikso.getmatrix.pagemodules.AnalyzeMod;
import com.epikso.getmatrix.pagemodules.GoogleSpeedMod;
import com.epikso.getmatrix.pagemodules.HomeMod;
import com.epikso.getmatrix.utils.ExcellUtil;
import com.epikso.getmatrix.utils.PropertyUtil;

public class Base 
{
	public static Properties prop;
	public static FileInputStream input;
	public static boolean isInitialized=false;
	public static String url;
	public static WebDriver driver=null;
	public static ExcellUtil util;
	public static AnalyzeMod anaMod;
	public static GoogleSpeedMod gooMod;
	public static HomeMod homMod;
	public static Base base;
	public static Boolean urlread=true;
	
	
	public void setDriver() 
	{
		if(urlread)	{
		url=prop.getProperty("Google_Speed");
		urlread=false;
		}
		else {
			url=prop.getProperty("GtMatrix_Url");	
		}
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_PATH);
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}

	public static void initialize() throws IOException 
	{
		if(!isInitialized) 
		{
			PropertyUtil.loadProperty();			
		}
	}

	@BeforeTest
	public void bt() throws IOException
	{
		 base=new Base();
		Base.initialize();
		base.setDriver();
		anaMod = new AnalyzeMod(driver);
		gooMod = new GoogleSpeedMod(driver);
		homMod = new HomeMod(driver);
		util=new ExcellUtil();
		
		
		
	}	

	@AfterMethod
	public void after() {
		driver.quit();;
	}}

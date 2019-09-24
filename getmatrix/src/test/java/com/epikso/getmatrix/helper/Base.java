package com.epikso.getmatrix.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.epikaso.getmatrix.config.Constants;
import com.epikso.getmatrix.utils.PropertyUtil;

public class Base 
{
	public static Properties prop;
	public static FileInputStream input;
	public static boolean isInitialized=false;
	public static String url;
	public static WebDriver driver;

	public void setDriver() 
	{
		url=prop.getProperty("Url");
		System.out.println(url);
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_PATH);
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void initialize() throws IOException 
	{
		if(!isInitialized) 
		{
			PropertyUtil.loadProperty();			
		}
	}

	@BeforeMethod
	public void bf() throws IOException
	{
		initialize();
		setDriver();
	}

}

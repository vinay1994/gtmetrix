package com.epikso.getmatrix.pagemodules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epikso.getmatrix.helper.Base;

public class GoogleSpeedMod extends Base
{
	int count=2, a=2;
		int speedM = 0,	speed = 0;
	@FindBy(css="input[type='text'][name='url']")
	public WebElement searchTxt;

	@FindBy(css="div[role='button']")
	public WebElement analyzeBtn;

	@FindBy(css="div[class='lh-gauge__percentage']")
	public static List<WebElement> deviceSpeed;
	@FindBy(css="div[class='tab-title tab-desktop']")
	public WebElement clickOndestop;


	public GoogleSpeedMod(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void searchUrl(String url) throws IOException, InterruptedException
	{
		searchTxt.sendKeys(url);
		analyzeBtn.click();
		util.writeDataString(getSpeedMob(),count, 5);

		Thread.sleep(3000);
		clickOndestop.click();
		util.writeDataString(getSpeedOnDestop(), count, 6);
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		searchTxt.clear();
	}
	public  int getSpeedMob() 
	{

		try {
			speedM=Integer.parseInt(deviceSpeed.get(0).getText());

		}

		catch(Exception e){
			speedM=0;
		}
		System.out.println(speedM);
		return speedM;
	}
	public  int getSpeedOnDestop() 
	{



		try {

			speed=Integer.parseInt(deviceSpeed.get(1).getText());


		}
		catch(Exception e){
			speed=0;
		}
		System.out.println(speed);
		return speed;
	}



	public void setUrls() throws IOException, InterruptedException {
		Map<Integer, String> links = util.readData();
		for(int i=0; i<links.size(); i++)
		{
			count++;
			searchUrl(links.get(i));

		}
	}
}

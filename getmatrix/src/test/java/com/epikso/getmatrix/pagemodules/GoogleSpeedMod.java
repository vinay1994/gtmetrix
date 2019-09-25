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
	@FindBy(css="input[type='text'][name='url']")
	public WebElement searchTxt;

	@FindBy(css="div[role='button']")
	public WebElement analyzeBtn;

	@FindBy(css="div[class='lh-gauge__percentage']")
	public List<WebElement> deviceSpeed;
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
		util.writeDataString(deviceSpeed.get(0).getText(), count, 5);
		
		Thread.sleep(3000);
		clickOndestop.click();
		util.writeDataString(deviceSpeed.get(1).getText(), count, 6);
		Thread.sleep(3000);
		driver.navigate().back();
		searchTxt.clear();
	}


	public List<Integer> getSpeed() 
	{
		List<Integer> s = new ArrayList<Integer>();
		int speed;
		for(int i=0; i < 2; i++)
		{
			speed=Integer.parseInt(deviceSpeed.get(0).getText());
			s.add(speed);
		}
		return s;

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

package com.epikso.getmatrix.pagemodules;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epikso.getmatrix.helper.Base;
import com.epikso.getmatrix.utils.ExcellUtil;

public class HomeMod extends Base
{
	int count=2, a=2;
	@FindBy(css="input[type='url'][name='url']")
	public WebElement searchText;

	@FindBy(css="div[class='analyze-form-button'] button[type='submit']")
	public WebElement testYourSiteBtn;

	public HomeMod(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
	}

	public void searchUrl(String link) throws InterruptedException, IOException 
	{
		System.out.println("vinay");	
		searchText.sendKeys(link);
		testYourSiteBtn.click();
		String[] grades = anaMod.getGrade();
		for(int b=0; b<grades.length; b++) {

			String grade = grades[b];
			util.writeData(grade,count,a);
		}
		a=2;
		double loadtime = anaMod.getLoadTime();
		util.writeDataDouble(loadtime,count);
		driver.navigate().back();
		searchText.clear();
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

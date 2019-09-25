package com.epikso.getmatrix.pagemodules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalyzeMod 
{
	@FindBy(css="div[class='report-score'] span i")
	public List<WebElement> gradeValue;
	
	@FindBy(css="div[class='report-page-detail'] span[class='report-page-detail-value']")
	public WebElement loadTime;
	
	public AnalyzeMod(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String[] getGrade() 
	{
		
		String[] s = new String[2];
		String cssValue, grade;
		try {
		for(int i = 0; i < 2; i++)
		{
			cssValue = gradeValue.get(i).getAttribute("class");
			grade = cssValue.substring(cssValue.length() - 1, cssValue.length());
			s[i]=grade;
		}
		}
		catch(Exception e) {}
		return s;
	}
	
	public double getLoadTime()
	{
		String loadTextWithS, loadTextWithoutS;
		loadTextWithS = loadTime.getText();
		loadTextWithoutS = loadTextWithS.substring(0, loadTextWithS.length() - 1);
		return Double.parseDouble(loadTextWithoutS);
	}
	
}

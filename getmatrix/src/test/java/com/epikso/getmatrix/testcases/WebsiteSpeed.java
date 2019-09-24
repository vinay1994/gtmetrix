package com.epikso.getmatrix.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.epikso.getmatrix.helper.Base;


public class WebsiteSpeed extends Base
{
	
	

	
	@Test(priority=1)
	public void getLoadAndGrade() throws IOException, InterruptedException
	{
		homMod.setUrls();
		
	}
	@Test(priority=2)
	public void getSpeed() throws IOException, InterruptedException
	{
		gooMod.setUrls();
		
	}
}

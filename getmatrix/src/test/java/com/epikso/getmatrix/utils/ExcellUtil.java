package com.epikso.getmatrix.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.epikaso.getmatrix.config.Constants;

public class ExcellUtil {
	String value;
	public static	int row;
	Map<Integer, String>map=new HashMap<Integer, String>();
	int key=0;
	public Map<Integer, String> readData() throws IOException {

		FileInputStream fis=new FileInputStream(Constants.EXCELL_FILE);

		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		row=sheet.getLastRowNum();

		for (int i=3;i<row; i++) {
			Row rw=sheet.getRow(i);
			value=rw.getCell(1).getStringCellValue();
			map.put(key++,value);

		}
		return map;

	}



	public void writeData(String grades,int count,int a) throws IOException
	{
		try
		{
			FileInputStream fis = new FileInputStream((Constants.EXCELL_FILE));	
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			FileOutputStream fos = null;
			XSSFRow rw = sheet.getRow(count);
			CellStyle style = wb.createCellStyle();
			Cell cell;

			if(!grades.toUpperCase().equals("A") || !grades.toUpperCase().equals("B"))
			{
				cell = rw.createCell(a);

				style.setFillForegroundColor(IndexedColors.RED.getIndex());  
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				cell.setCellValue(grades);	

				cell.setCellStyle(style);
				
			}
			else
			{	
				cell = rw.createCell(a);
			}
			fos = new FileOutputStream(Constants.EXCELL_FILE);
			wb.write(fos);
			fis.close();
			wb.close();
			fos.close();



		}

		catch(FileNotFoundException fnf)
		{

		}
	}
	public void writeDataDouble(double loadTime,int count) throws IOException
	{
		try
		{
			FileInputStream fis = new FileInputStream((Constants.EXCELL_FILE));	
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

			XSSFRow rw = sheet.getRow(count);
			
			CellStyle style = wb.createCellStyle();
			Cell cell = null;


			if(loadTime > 4)
			{
				cell = rw.createCell(4);
				cell.setCellValue(loadTime);	
				style.setFillForegroundColor(IndexedColors.RED.getIndex());  
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				cell.setCellStyle(style);
				System.out.println("Inside load time");
			}
			else
			{
				cell.setCellValue(loadTime);	
			}
			
			FileOutputStream fos = new FileOutputStream(Constants.EXCELL_FILE);
			fis.close();
			wb.write(fos);
			wb.close();
			fos.close();

		}
		catch(FileNotFoundException fnf)
		{

		}
	}
	public void writeDataString(String speed,int count,int cellNum) throws IOException
	{
		try
		{
			
			
			FileInputStream fis = new FileInputStream((Constants.EXCELL_FILE));	
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

			XSSFRow rw = sheet.getRow(count);
			CellStyle style = wb.createCellStyle();

			if(Integer.parseInt(speed) > 10 && cellNum == 5)
			{
				Cell cell;
				cell = rw.createCell(4);
				cell.setCellValue(speed);	
				style.setFillForegroundColor(IndexedColors.RED.getIndex());  
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				cell.setCellStyle(style);
			}
			else
			{	
				rw.createCell(cellNum).setCellValue(speed);			
			}
			FileOutputStream fos = new FileOutputStream(Constants.EXCELL_FILE);
			fis.close();
			wb.write(fos);
			wb.close();
			fos.close();

		}
		catch(FileNotFoundException fnf)
		{

		}
	}

}

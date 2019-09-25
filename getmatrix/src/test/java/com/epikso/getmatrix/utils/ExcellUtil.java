package com.epikso.getmatrix.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
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
		System.out.println(row);
		for (int i=3;i<row; i++) {
			Row rw=sheet.getRow(i);
			if (rw.getCell(1).getStringCellValue() != "") {
				value=rw.getCell(1).getStringCellValue();
				
			map.put(key++,value);
		}
			else {
				continue;
			}
		}
		System.out.println(map.size());
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
			Cell cell;
			if (rw.getCell(1).getStringCellValue() != "")
			{
			CellStyle style = wb.createCellStyle();
			

			if(grades.toUpperCase().equals("A"))
			{
			
				cell = rw.createCell(a);
				cell.setCellValue(grades);
			}
			else if(grades.toUpperCase().equals("B")) {
				cell = rw.createCell(a);
				cell.setCellValue(grades);
			}
			else
			{	
				style.setFillForegroundColor(IndexedColors.RED1.getIndex());  
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
			
				
				cell = rw.createCell(a);
				cell.setCellValue(grades);	
				cell.setCellStyle(style);
				
				
			}
			fos = new FileOutputStream(Constants.EXCELL_FILE);
			wb.write(fos);
			fis.close();
			wb.close();
			fos.close();


			}
			else {
				cell = rw.createCell(a);
			}
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
			Cell cell = null;
			if (rw.getCell(1).getStringCellValue() != "") {
				
			CellStyle style = wb.createCellStyle();
			

			cell = rw.createCell(4);
			if(loadTime > 4)
			{
				cell.setCellValue(loadTime);	
				style.setFillForegroundColor(IndexedColors.RED1.getIndex());  
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
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
			else {
				cell = rw.createCell(4);
			}
		}
		catch(FileNotFoundException fnf)
		{

		}
			
	}
	
	
	
	public void writeDataString(double speed,int count,int cellNum) throws IOException
	{
		
		try
		{


			FileInputStream fis = new FileInputStream((Constants.EXCELL_FILE));	
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

			XSSFRow rw = sheet.getRow(count);
			Cell cell;
			if (rw.getCell(1).getStringCellValue() != "")
			
			{	
			
			CellStyle style = wb.createCellStyle();
			
			if(speed > 10 && cellNum == 5)
			{				
				style.setFillForegroundColor(IndexedColors.RED1.getIndex());  
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				style.setFillForegroundColor(IndexedColors.RED1.getIndex());  
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
				cell = rw.createCell(5);
				cell.setCellValue(speed);
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
			else
			{
				cell = rw.createCell(5);
			}
		}
		
		catch(FileNotFoundException fnf)
		{

		}
	}

	
	
	
	
	
	
}

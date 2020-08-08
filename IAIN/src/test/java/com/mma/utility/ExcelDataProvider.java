package com.mma.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataProvider {
    
	static XSSFWorkbook wb;
   static XSSFSheet sheet;
    
    public ExcelDataProvider()
    {
		File file = new File("./TestData/ExcelData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println("Unable to Read the Excel File:" + e.getMessage());
		}
		
    }
    
    public  String getStringData(int sheetIndex, int row, int cell)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}
	public double getNumericData(int sheetIndex, int row, int cell)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getNumericCellValue();
	}
	public String getStringData(String sheetName, int row, int cell)//method Overloading
	{
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	public  static Object[][] ExcelDataProvide(String sheetName) {
        
		File file = new File("./TestData/ExcelData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println("Unable to Read the Excel File:" + e.getMessage());
		}

		sheet=wb.getSheet(sheetName);
		System.out.println("Sheet Name:" +sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("Total rows" + sheet.getLastRowNum()+ "-------" + "Total Columns" + sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
				
			}
		}
		
		return data;

	}
	
	
	
}

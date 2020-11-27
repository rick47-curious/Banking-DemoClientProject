package com.guru99bank.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	String data[] = null;
	public static String[][] readExcelData() {
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//TestData.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheet("inputdata");
			
			Row row = sheet.getRow(1);
			
			int totalCells = row.getLastCellNum();
			
			String data[][] = new String[1][totalCells]; 
			for (int i=0;i<row.getLastCellNum();i++) {
				
				data[0][i] = row.getCell(i).toString();
			}
			
			return data;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void waitForVisibility(WebDriver driver,By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}

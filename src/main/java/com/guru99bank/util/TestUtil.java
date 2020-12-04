package com.guru99bank.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	public static int implicit_Wait_Time = 10;
	public static String homePage_Title = "Guru99 Bank Manager HomePage";
	
	
	public static String pattern = ":";
	public static String first_Pattern = "mngr";
	//To check for numbers ranging between 0-9 with any repetition
	public static String second_Pattern = "[0-9]+";
	
	
	
	public static String[][] readExcelData() {

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//resources//TestData.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheet("inputdata");

			Row row = sheet.getRow(0);

			int totalRows = sheet.getLastRowNum();
			int totalCells = row.getLastCellNum();

			String data[][] = new String[totalRows][totalCells];

			for (int i = 0; i < totalRows; i++) {

				row = sheet.getRow(i + 1);

				for (int j = 0; j < totalCells; j++) {

					data[i][j] = row.getCell(j).toString();
				}
			}
			wb.close();
			return data;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static void waitForVisibility(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void takeScreenshot(WebDriver driver) {
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+timestamp+"_output.jpg";
		
		try {
			FileUtils.copyFile(file, new File(destination));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}

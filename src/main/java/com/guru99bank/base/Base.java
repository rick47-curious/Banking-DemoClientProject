package com.guru99bank.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Base {
	
	private WebDriver driver;
	FileInputStream fis;
	Properties prop;
	public WebDriver initializeBrowser() {
		
		try {
			 fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
			
			 prop = new Properties();
			 
			 prop.load(fis);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
			
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver.exe");
			
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(prop.getProperty("firefox_application"));
			
			firefoxOptions.setProfile(firefoxProfile);
			driver = new FirefoxDriver(firefoxOptions);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}

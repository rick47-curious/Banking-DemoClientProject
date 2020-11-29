package com.guru99bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Locators
	private By userId = By.name("uid");
	private By password = By.name("password");
	private By loginButton = By.name("btnLogin");
	
	
	public void loginUser(String id,String pass) {
		/*
		 *User enters the userId and password and clicks on the Login button 
		 */
		
		driver.findElement(userId).clear();
		driver.findElement(userId).sendKeys(id);
		
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(loginButton).click();
		
	}
	
	
}

package com.guru99bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerHomePage {

	WebDriver driver = null;
	
	public ManagerHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By userName = By.xpath("(//table[@align='center'])[2]//tr[3]/td[1]");
	
	public WebElement getUserElement() {
		
		return driver.findElement(userName);
	}
}

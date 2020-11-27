package com.guru99bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomePage {

	WebDriver driver = null;
	
	public ManagerHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public By userName = By.xpath("(//table[@align='center'])[2]//tr[3]/td[1]");
	
	public String getUserName() {
		
		return driver.findElement(userName).getText();
	}
}

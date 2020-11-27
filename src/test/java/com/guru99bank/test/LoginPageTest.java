package com.guru99bank.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import com.guru99bank.base.Base;
import com.guru99bank.pages.LoginPage;
import com.guru99bank.pages.ManagerHomePage;
import com.guru99bank.util.TestUtil;

public class LoginPageTest extends Base {

	protected WebDriver driver = null;
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = TestUtil.readExcelData(); 
		
		return data;
			
	}
	
	
	@BeforeClass
	public void setUp() {
		
		driver = initializeBrowser();
	}
	
	
	@Test(dataProvider = "getData")
	public void userLogin(String id,String pass) {
		
		LoginPage loginPage = new LoginPage(driver);
		ManagerHomePage managerHomePage = new ManagerHomePage(driver);
		
		loginPage.loginUser(id,pass);
		
		TestUtil.waitForVisibility(driver,managerHomePage.userName);
		
		String welcomeText  = managerHomePage.getUserName();
		
		Assert.assertTrue(welcomeText.contains("mngr296799"));
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
}

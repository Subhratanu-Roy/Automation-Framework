package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class TC_loginpageTest extends Base{

	
	@Test
	public void login() throws IOException
	{
		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.getUserName().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.loginMethod().click();
		
		String a = driver.getTitle();
		if (a.equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			getScreenshot(driver, "login");
			Assert.assertTrue(false);
			
		}
		
		log.info("Operation is going on");
		
		
		
	}
}

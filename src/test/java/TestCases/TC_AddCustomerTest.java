package TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CustomerPageObjects;
import PageObjects.LoginPageObjects;

public class TC_AddCustomerTest extends Base {

	@Test
	public void addCustomer() throws IOException, InterruptedException {
		try {

			LoginPageObjects lpo = new LoginPageObjects(driver);
			lpo.getUserName().sendKeys(username);
			lpo.getPassword().sendKeys(password);
			lpo.loginMethod().click();

			Thread.sleep(3000);
			CustomerPageObjects cpo = new CustomerPageObjects(driver);
			cpo.newCustomer();
			Thread.sleep(2000);
			WebElement frame = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
			driver.switchTo().frame(frame);
			driver.findElement(By.cssSelector("#dismiss-button > div > svg > path:nth-child(1)")).click();

			driver.switchTo().defaultContent();

			cpo.getName("Kuntal");
			cpo.getGender();
			cpo.getDate("04", "01", "2022");
			cpo.getAddress("India");
			cpo.getCity("Kolkata");
			cpo.getState("West Bengal");
			cpo.getPin("7869504");

			String newMail = getRandomMail() + "@gmail.com";
			cpo.getMail(newMail);

			String number = getRandomNumber();
			cpo.getPhone(number);

			cpo.getPassword("password");
			Thread.sleep(3000);
			cpo.getSubmit();

		} catch (Exception e) {
		}

		boolean value = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (value == true) {
			Assert.assertTrue(true);
		} else {

			getScreenshot(driver, "addCustomer");
			Assert.assertTrue(false);
		}

	}

}

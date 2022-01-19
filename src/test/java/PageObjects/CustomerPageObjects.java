package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObjects {
	WebDriver driver;

	public CustomerPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "New Customer")
	WebElement newCust;

	@FindBy(name = "name")
	WebElement name;

	@FindBy(name = "rad1")
	WebElement gender;

	@FindBy(id = "dob")
	WebElement dob;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pin;

	@FindBy(name = "telephoneno")
	WebElement phn;

	@FindBy(name = "emailid")
	WebElement mail;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;

	public void newCustomer() {
		newCust.click();
	}

	public void getName(String n) {
		name.sendKeys(n);
	}

	public void getGender() {
		gender.click();
	}

	public void getDate(String d, String m, String y) {
		dob.sendKeys(d);
		dob.sendKeys(m);
		dob.sendKeys(y);
	}

	public void getAddress(String add) {
		address.sendKeys(add);
	}

	public void getCity(String c) {
		city.sendKeys(c);
	}

	public void getState(String s) {
		state.sendKeys(s);
	}

	public void getPin(String number) {
		pin.sendKeys(number);
	}

	public void getPhone(String p) {
		phn.sendKeys(p);
	}

	public void getMail(String e) {

		mail.sendKeys(e);
	}

	public void getPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void getSubmit()
	{
		submit.click();
	}

}

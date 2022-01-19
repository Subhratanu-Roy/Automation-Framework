package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement userid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement login;
	
	
	@FindBy(linkText="Log out")
	WebElement logout;

	public WebElement getUserName() {
		return userid;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement loginMethod() {
		return login;
	}
	
	public WebElement logout()
	{
		return logout;
	}

}

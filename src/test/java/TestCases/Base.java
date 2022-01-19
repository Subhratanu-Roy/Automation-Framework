package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ReadConfig;

public class Base {

	ReadConfig readconfig = new ReadConfig();

	public String username = readconfig.getUserName();

	public String password = readconfig.getPassword();
	public String url = readconfig.getUrl();
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if (br.contains("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		
		else if (br.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(br.contains("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		log.info("Initialize browser");
	}

	@AfterClass
	public void teardown()

	{
		driver.quit();
		log.info("Browser is closed");
	}
	

	public void getScreenshot(WebDriver driver, String tcName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\Screenshots\\"+ tcName +".png"));
		
		System.out.println("ss taken");
	}
	
	public String getRandomMail()
	{
		String mail = RandomStringUtils.randomAlphabetic(5);
		return mail;
	}
	
	public String getRandomNumber()
	{
		String num = RandomStringUtils.randomNumeric(10);
		return num;
	}

}

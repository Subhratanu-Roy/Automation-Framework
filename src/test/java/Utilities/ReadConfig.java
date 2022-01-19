package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");

			prop.load(fis);

		} catch (Exception e) {

		}
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

	public String geBrowser() {
		return prop.getProperty("browser");
	}

	public String getChromepath() {
		return prop.getProperty("chromepath");
	}

}

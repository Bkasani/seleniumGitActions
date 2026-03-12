package com.oranghrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	protected Properties prop;
	protected WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {
		// load the Configuration file

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties");
		prop.load(fis);
		// Initialize the webDriver based on the browser
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("No browser" + browser);
		}
		// setup implicitwait
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		// maximize driver
		driver.manage().window().maximize();

		// navigate to url

		driver.get(prop.getProperty("url"));

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}

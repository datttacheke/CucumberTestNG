package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis1 = new FileInputStream(
				"E:\\TESTING\\CucumberSeleniumProject\\CucumberFrameworkJunit\\src\\test\\resources\\global.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");

		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		// result = testCondition ? value1 : value2
		System.out.println("browser_properties: " + browser_properties);
		System.out.println("browser_maven" + browser_maven);
		String browser = browser_maven != null ? browser_maven : browser_properties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"E:\\TESTING\\Softwars\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();// driver gets the life
				/*
				 * ChromeOptions options = new ChromeOptions();
				 * options.addArguments("headless"); driver = new ChromeDriver(options);
				 */
			}
			if (browser.equalsIgnoreCase("firefox")) {
				// System.setProperty("webdriver.gecko.driver",
				// "E:\\TESTING\\Softwars\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Firefox browser is open");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

		return driver;

	}

}

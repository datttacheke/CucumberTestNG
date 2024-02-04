package rahulshettyacademy.CucumberFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
	/*
	 * System.setProperty("webdriver.gecko.driver",
	 * "E:\\TESTING\\Softwars\\geckodriver.exe");
	 */

	WebDriver driver = new FirefoxDriver();
	 System.out.println("Louch FirefoxDriver");
	 System.out.println("I am US");
  }
}

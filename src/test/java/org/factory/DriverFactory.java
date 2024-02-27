package org.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String bName) {
		WebDriver driver = null;
		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			//tlDriver.set(new ChromeDriver(options));
		}
		else if(bName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			//tlDriver.set(new EdgeDriver(options));
		}
		else if(bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			//tlDriver.set(new FirefoxDriver(options));
		}
		else {
			System.out.println("Invalid Browser name");
		}
		//tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//return tlDriver.get();
		//OR
		//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//return getDriver();
		//OR
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	/*
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	*/
}

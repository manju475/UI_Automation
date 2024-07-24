package com.ui_automation.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.ui_automation.utility.ReadPropertyFile;

@Listeners(com.ui_automation.utility.TestNGListeners.class)
public class BaseClass {
	public static WebDriver driver;
	public static String browserName;
	public static String url;
	public static ReadPropertyFile prop;
	
	
	@BeforeClass
	public static void LaunchBrowser() throws FileNotFoundException, IOException {
		try {
			prop = new ReadPropertyFile();
			browserName = prop.getBrowser();
			url=prop.getURL();
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}else {
				System.out.println("Browser does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}

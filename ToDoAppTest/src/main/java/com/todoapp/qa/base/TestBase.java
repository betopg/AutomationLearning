package com.todoapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.todoapp.qa.utilities.TestUtilities;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		//To read the properties file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/juan padilla/Documents/eclipseWorkspace/ToDoAppTest/src/main/java/com/todoapp/qa/config/config.properties");
			prop.load(ip);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//Function that will initialize all the browsers
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/juan padilla/Documents/ChromeDriver/chromedriver");
		    driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}

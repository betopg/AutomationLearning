package com.todoapp.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.todoapp.qa.base.TestBase;
import com.todoapp.qa.pages.HomePage;
import com.todoapp.qa.pages.LoginPage;
import com.todoapp.qa.pages.MyTasksPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyTasksPage myTasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginPage = new LoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		
	}
	
	@Test(priority = 1)
	public void verifyMyTasksLinkPresent() {
	try {
		homePage.MyTasksLinkPresent();
		System.out.println("Element Exist");
	}catch(NoSuchElementException e) {
		System.out.println("Element not Exist");
	}
	myTasksPage = homePage.MyTasksLink();
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

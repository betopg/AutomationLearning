package com.todoapp.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.todoapp.qa.base.TestBase;
import com.todoapp.qa.pages.HomePage;
import com.todoapp.qa.pages.LoginPage;
import com.todoapp.qa.pages.ManageSubtasksPage;
import com.todoapp.qa.pages.MyTasksPage;
import com.todoapp.qa.utilities.TestUtilities;

public class ManageSubTasksPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyTasksPage myTasksPage;
	ManageSubtasksPage manageSubtasksPage;
	
	public ManageSubTasksPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginPage = new LoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        myTasksPage = homePage.MyTasksLink();
        
	}
	
	
	
	@Test(enabled = false)
	public void verifyAButtonLabelManageSubtask() {
		String name = myTasksPage.getManageSubtasksName();
		Assert.assertEquals(name, "(1) Manage Subtasks");	
	}
	
	@Test(enabled = true)
	public void verifyItOpensANewWindow() {
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'(1) Manage Subtasks')]")).click();
	
		manageSubtasksPage.addNewSubTask(prop.getProperty("SubTaskDescription"), prop.getProperty("date"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

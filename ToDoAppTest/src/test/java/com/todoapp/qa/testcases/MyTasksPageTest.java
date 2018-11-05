package com.todoapp.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.todoapp.qa.base.TestBase;
import com.todoapp.qa.pages.HomePage;
import com.todoapp.qa.pages.LoginPage;
import com.todoapp.qa.pages.MyTasksPage;

public class MyTasksPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyTasksPage myTasksPage;
	
	public MyTasksPageTest() {
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
	public void loginPageTitleTest() {
		String title = myTasksPage.validatePageTitle();
		Assert.assertEquals(title, "ToDo Rails and Angular");	
	}
	
	@Test(enabled = false)
	public void verifyText() {
		String text = myTasksPage.getNavigationsName();
		Assert.assertEquals(text, "Hey Juan, this is your todo list for today:");
	}
	
	@Test(enabled = false)
	public void verifyHittingEnterAddingATask() {
		myTasksPage.addNewTaskByHittingEnter(prop.getProperty("task1"));
		String text = driver.findElement(By.xpath("//a[contains(text(), 'newTaskEnter')]")).getText();
		Assert.assertEquals(prop.getProperty("task1"), text);
		
	}
	
	@Test(enabled = false)
	public void verifyAddingATaskByClickingAddButton() {
		myTasksPage.addNewTaskByClickingAddButton(prop.getProperty("task2"));
		String text = driver.findElement(By.xpath("//a[contains(text(), 'newTaskAddButton')]")).getText();
		Assert.assertEquals(prop.getProperty("task2"), text);
		
	}
	
	@Test(enabled = false)
	public void verifyNeedMoreThanTwoCharactersToAddANewTask() {
		myTasksPage.verifyNeedMoreThanTwoCharactersToAddTask(prop.getProperty("task3"));
		String error = "You can't add the task";
		Assert.assertEquals(prop.getProperty("task1"), error);
		
	}
	
	@Test(enabled = false)
	public void verifyYouCantAddATaskWithMoreThan250Characters() {
		myTasksPage.verifyTheTaskCantBeMoreThan250Characters(prop.getProperty("task4"));
		String error = "You can't add the task";
		Assert.assertEquals(prop.getProperty("task4"), error);
		
	}
	
	@Test(enabled = false)
	public void verifyThatPreviousTasksAppendsAreAdded() {
		
		Assert.assertEquals(prop.getProperty("task1"), "newTaskEnter");
		Assert.assertEquals(prop.getProperty("task2"), "newTaskAddButton");
		
	}
	
	@Test(enabled = false)
	public void verifyTextManageSubtasks() {
		String text = myTasksPage.getManageSubtasksName();
		Assert.assertEquals(text, "Manage Subtasks");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}

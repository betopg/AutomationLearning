package com.todoapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoapp.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PAGE FACTORY - OR
	@FindBy (xpath = "//a[contains(text(),'ToDo App')]")
	WebElement ToDo;
	
	@FindBy (xpath = "//a[contains(text(),'Home')]")
	WebElement Home;
	
	@FindBy (xpath = "//a[contains(text(),'My Tasks')]")
	WebElement MyTasksLink;
	
	@FindBy (xpath = "//a[contains(text(),'Welcome, Juan!')]")
	WebElement WelcomeMessage;
	
	@FindBy (xpath = "//a[contains(text(),'Sign Out')]")
	WebElement SignOutLinlk;

	@FindBy(xpath = "//a[@href='/tasks']")
	WebElement MyTasksbtn;
	
	//Creation of constructor to initialize all the web elements 
		public HomePage() {
			 PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public WebElement MyTasksLinkPresent() {
			return MyTasksLink;
		}
		
		public MyTasksPage MyTasksLink() {
			MyTasksLink.click();
			return new MyTasksPage();
			
		}
}

package com.todoapp.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoapp.qa.base.TestBase;

public class MyTasksPage extends TestBase{
	
	//PAGE FACTORY - OR
	@FindBy (xpath = "//a[contains(text(),'ToDo App')]")
	WebElement ToDo;
	
	@FindBy (xpath = "//a[contains(text(),'Home')]")
	WebElement Home;
	
	@FindBy (xpath = "//a[contains(text(),'My Tasks')]")
	WebElement MyTasksLink;
	
	@FindBy (xpath = "//h1[contains(text(),\"Juan's ToDo List\")]")
	WebElement WelcomeMessage;
	
	@FindBy (xpath = "//a[contains(text(),'Sign Out')]")
	WebElement SignOutLinlk;

	@FindBy(xpath = "//h1[contains(text(), 'Juan's ToDo List')]")
	WebElement NavigationBar;
	
	@FindBy(id = "new_task")
	WebElement MainTextField;
	
	@FindBy(xpath = "//span[@class='input-group-addon glyphicon glyphicon-plus']")
	WebElement AddTasksBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-xs btn-primary ng-binding']")
	WebElement ManageSubstaksBtn;
	
	//Creation of constructor to initialize all the web elements 
		public MyTasksPage() {
			 PageFactory.initElements(driver, this);
		}
		
 //Actions

		public String validatePageTitle() {
			return driver.getTitle();
		}
		
		public String getNavigationsName() {
			String navTitle = NavigationBar.getText();
			return navTitle;
		} 
		
		public MyTasksPage addNewTaskByHittingEnter(String task) {
			MainTextField.sendKeys(task);
			MainTextField.sendKeys(Keys.ENTER);
			return new MyTasksPage();
			
		}
		public MyTasksPage addNewTaskByClickingAddButton(String task) {
			MainTextField.sendKeys(task);
			AddTasksBtn.click();
			return new MyTasksPage();	
		}
		
		public MyTasksPage verifyNeedMoreThanTwoCharactersToAddTask(String task) {
			MainTextField.sendKeys(task);
			AddTasksBtn.click();
			return new MyTasksPage();
			
		}
		public MyTasksPage verifyTheTaskCantBeMoreThan250Characters(String task) {
			MainTextField.sendKeys(task);
			AddTasksBtn.click();
			return new MyTasksPage();
			
		}

		public String getManageSubtasksName() {
			String manageBtn = ManageSubstaksBtn.getText();
			return manageBtn;
		}
		
		public MyTasksPage clickManageSubtasksBtn() {
			ManageSubstaksBtn.click();
			return new MyTasksPage();
		}
		
		
}

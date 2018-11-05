package com.todoapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoapp.qa.base.TestBase;

public class ManageSubtasksPage extends TestBase{
	
	//PAGE FACTORY - OR
	
	@FindBy (xpath = "//h3[@class='modal-title ng-binding']")
	WebElement NameOfTheTask;
	
	@FindBy (id = "edit_task")
	WebElement TaskId;
	
	@FindBy (id = "new_sub_task")
	WebElement SubTaskDescription;
	
	@FindBy (name = "due_date")
	WebElement Date;
	
	@FindBy (id = "add-subtask")
	WebElement AddBtn;
	
	@FindBy (xpath = "//button[contains(text(),'Remove SubTask')]")
	WebElement RemoveSubtaskBtn;
	
	@FindBy (xpath = "//button[contains(text(),'Close')]")
	WebElement CloseBtn;
	
	//Creation of constructor to initialize all the web elements 
	public ManageSubtasksPage() {
		 PageFactory.initElements(driver, this);
	}
	
//Actions
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public String getNavigationsName() {
		String readOnlyId = NameOfTheTask.getText();
		return readOnlyId;
	}

	public ManageSubtasksPage addNewSubTask(String task, String date) {
		SubTaskDescription.sendKeys(task);
		Date.sendKeys(date);
		AddBtn.click();
		return new ManageSubtasksPage();
	}
	
	public ManageSubtasksPage addNewSubTaskWithMoreThan250CharactersAndWrongDate(String task, String date) {
		SubTaskDescription.sendKeys(task);
		Date.sendKeys(date);
		AddBtn.click();
		return new ManageSubtasksPage();
	}
	
	public void closeSubTaskManagement() {
		CloseBtn.click();
		
	}
	
}

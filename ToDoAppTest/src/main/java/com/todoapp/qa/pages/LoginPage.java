package com.todoapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoapp.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PAGE FACTORY - OR
	
	@FindBy (xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(id = "user_email")
	WebElement user;
	
	@FindBy(id = "user_password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;
	
	//@FindBy(xpath = "//a[@href='Sign In']")
	//@FindBy(xpath = "//a[contains(@href='Sign up')]")
	@FindBy(xpath = "//a[contains(text(), 'Sign In')]")	
	WebElement SignUpLink;
	
	//Creation of constructor to initialize all the web elements 
	public LoginPage() {
		 PageFactory.initElements(driver, this);
	}
	

	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void signUp() {
		SignUpBtn.click();
	}
	
	public HomePage login(String un, String pwd) {
		SignUpLink.click();
		user.sendKeys(un);
		password.sendKeys(pwd);
		SignInBtn.click();
		
		return new HomePage();
		
	}
	
}

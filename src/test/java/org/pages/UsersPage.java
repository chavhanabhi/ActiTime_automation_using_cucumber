package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	private WebDriver driver;
	
	// 1. WebElements
	@FindBy(xpath = "//div[text()='Add User']")
	private WebElement addUserBtn;
	
	@FindBy(id = "userDataLightBox_firstNameField")
	private WebElement firstnameField;
	
	@FindBy(id = "userDataLightBox_lastNameField")
	private WebElement lastnameField;
	
	@FindBy(id = "userDataLightBox_emailField")
	private WebElement emailField;
	
	@FindBy(id = "userDataLightBox_usernameField")
	private WebElement usernameField;
	
	@FindBy(id = "userDataLightBox_passwordField")
	private WebElement passwordField;
	
	@FindBy(id = "userDataLightBox_passwordCopyField")
	private WebElement passwordCopyField;
	
	@FindBy(xpath = "//span[text()='Create User']")
	private WebElement createUserBtn;
	
	// 2. Constructor
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// 3. Page Action Methods
	public void clickOnAddUserBtn() {
		addUserBtn.click();
	}
	
	public void enterFirstname(String fname) {
		firstnameField.sendKeys(fname);
	}
	
	public void enterLastname(String lname) {
		lastnameField.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterUsername(String uname) {
		usernameField.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}
	
	public void reenterPassword(String pwdCopy) {
		passwordCopyField.sendKeys(pwdCopy);
	}
	
	public void clickOnCreateUserBtn() {
		createUserBtn.click();
	}
	public boolean isAddUserBtndisplayed() {
		return addUserBtn.isDisplayed();
	}
}

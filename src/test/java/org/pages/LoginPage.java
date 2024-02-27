package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.GenericUtility;

public class LoginPage extends GenericUtility{
	private WebDriver driver;
	
	//1. WebElements
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(css = ".textField.pwdfield")
	private WebElement passwordField;
	
	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepMeLoginCheckBox;
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	@FindBy(css = "#logoContainer img")
	private List<WebElement> loginLogos;
	
//	@FindBy(id = "logoutLink")					//this should present in DashboardPage
//	private WebElement logoutLink;
	
	//2. Constructor
	
	public LoginPage(WebDriver driver) {
		 //PageFactory.initElements(driver, LoginPage.class);
		 //OR
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
	}
	
	//3. Page Action methods
	
	public boolean isUsernameFieldDisplayed() {
		//Boolean flag = usernameField.isDisplayed();
		//return flag;
		return usernameField.isDisplayed();
	}
	public boolean isPasswwordFieldDisplayed() {
		return passwordField.isDisplayed();
	}
	public boolean isKeepMeLoginCheckBoxDisplayed() {
		return keepMeLoginCheckBox.isDisplayed();
	}
	public boolean isLoginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}
	public boolean isLoginLogosDisplayed() {
		for(int i=0; i<2; i++) {   // we have verify two logos are displayed that why 2 is written
			if(!loginLogos.get(i).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public String getLoginPageTitle() {
		//String title = driver.getTitile();
		//return title;
		return driver.getTitle();
	}
	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	public void enterPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
}

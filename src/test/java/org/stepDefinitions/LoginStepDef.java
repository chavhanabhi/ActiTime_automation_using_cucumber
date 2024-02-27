package org.stepDefinitions;

import java.util.Properties;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.testng.Assert;
import org.utilities.ConfigReader;
import org.utilities.GenericUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	//public static WebDriver driver;
	//private Properties prop;
	private LoginPage lpObj;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		/*
		ConfigReader cr = new ConfigReader();
		prop = cr.getProp();
		GenericUtility gu = new GenericUtility();
		driver= gu.startUp(prop.getProperty("bName"), prop.getProperty("URL"));
		lpObj = new LoginPage(driver);
		*/
		AppHooks.driver.get(AppHooks.prop.getProperty("URL"));
		AppHooks.scn.log("Launched URL : " + AppHooks.prop.getProperty("URL"));
		lpObj = new LoginPage(AppHooks.driver);
		
	}
	
	@Then("Login page URL is displayed as {string}")
	public void login_page_URL_is_displayed_as(String expURL) {
		Assert.assertEquals(lpObj.getLoginPageURL()	, expURL);
		System.out.println("  - Login page URL is as expected");
		AppHooks.scn.log("Login page URL is as expected");
	}
	
	@Then("Login page title is displayed as {string}")
	public void login_page_title_is_displayed_as(String expTitle) {
		Assert.assertEquals(lpObj.getLoginPageTitle(), expTitle);
		System.out.println("  - Login page title is as expected");
		AppHooks.scn.log("Login page title is as expected");
	}
	
	@Then("Username field is displayed")
	public void username_field_is_displayed() {
		Assert.assertTrue(lpObj.isUsernameFieldDisplayed());
		System.out.println("  - Username field is displayed");
		AppHooks.scn.log("Username field is displayed");
	}
	
	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		Assert.assertTrue(lpObj.isPasswwordFieldDisplayed());
		System.out.println("  - password field is displayed");
		AppHooks.scn.log("password field is displayed");
	}
	
	@Then("Keep me login check box is displayed")
	public void keep_me_login_check_box_is_displayed() {
		Assert.assertTrue(lpObj.isKeepMeLoginCheckBoxDisplayed());
		System.out.println("  - Keep me login check box is displayed");
		AppHooks.scn.log("Keep me login check box is displayed");
	}
	
	@Then("Login logos are displayed")
	public void login_Logos_are_displayed() {
		Assert.assertTrue(lpObj.isLoginLogosDisplayed());
		System.out.println("  - Login logos are displayed");
		AppHooks.scn.log("Login logos are displayed");
	}
	
	@Then("Login button is displayed")
	public void login_button_is_displayed() {
	   Assert.assertTrue(lpObj.isLoginBtnDisplayed());
	   System.out.println("  - Login button is displayed");
	   AppHooks.scn.log("Login button is displayed");
	}

	@When("User enters username")
	public void user_enters_username() {
	    lpObj.enterUsername(AppHooks.prop.getProperty("username"));
	    System.out.println("  - Entered username is : " + AppHooks.prop.getProperty("username"));
	    AppHooks.scn.log("Entered username is : " + AppHooks.prop.getProperty("username"));
	}

	@When("User enters password")
	public void user_enters_password() {
	    lpObj.enterPassword(AppHooks.prop.getProperty("password"));
	    System.out.println("  - Password entered");
	    AppHooks.scn.log("Password entered");
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
	   lpObj.clickOnLoginBtn();
	   System.out.println("  - Clicked on login button");
	   AppHooks.scn.log("Clicked on login button");
	}
	
	@When("User enters {string} as username")
	public void user_enters_as_username(String username) {
		//System.out.println("username : " + username);
		//lpObj.enterUsername(username);
	}
	
	@When("User enters {string} as password")
	public void user_enters_as_password(String password) {
		//System.out.println("password : " + password);
		//lpObj.enterPassword(password);
	}
}

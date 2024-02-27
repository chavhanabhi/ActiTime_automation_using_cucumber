package org.stepDefinitions;

import org.applicationHooks.AppHooks;
import org.pages.UsersPage;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepDef {
	private UsersPage up_obj;
	
	@Then("Users page is displayed")
	public void users_page_is_displayed() {
		up_obj = new UsersPage(AppHooks.driver);
	    Assert.assertTrue(up_obj.isAddUserBtndisplayed());
	}
	@When("User clicks on add user button")
	public void user_clicks_on_add_user_button() {
	    up_obj.clickOnAddUserBtn();
	}
	@When("User enters firstname")
	public void user_enters_firstname() {
	    up_obj.enterFirstname("Virat");
	}
	@When("User enters lastname")
	public void user_enters_lastname() {
	    up_obj.enterLastname("Kohli");
	}
	@When("User enters email")
	public void user_enter_email() {
	    up_obj.enterEmail("xyz@gmail.com");
	}
	@When("User enters new username")
	public void user_enters_new_username() {
		up_obj.enterUsername("vk");
	}
	@When("User enters new password")
	public void user_enters_new_password() {
		up_obj.enterPassword("vk18");
	}
	@When("User reenters password")
	public void user_reenters_password() {
	    up_obj.reenterPassword("vk18");
	}
	@When("User clicks on create user button")
	public void user_clicks_on_create_user_button() {
	    up_obj.clickOnCreateUserBtn();
	}
	
}

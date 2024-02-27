package org.stepDefinitions;

import org.applicationHooks.AppHooks;
import org.pages.TasksPage;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TasksStepDef {
	private TasksPage tp_obj;
	
	@Then("Tasks page is displayed")
	public void tasks_page_is_displayed() {
	    tp_obj = new TasksPage(AppHooks.driver);
	    Assert.assertTrue(tp_obj.verifyCustomerAndProjectHeadingDisplayed());
	}
	@When("User clicks on add new button")
	public void user_clicks_on_add_new_button() {
		tp_obj.clickOnAddNewBtn();
	}
	@When("User click on new customer button")
	public void user_click_on_new_customer_button() {
	    tp_obj.clickOnNewCustomerBtn();
	}
	@When("User enters customer name")
	public void user_enters_customer_name() {
	    tp_obj.enterCustomerName("xyz");
	}
	@When("User enters description")
	public void user_enters_description() {
	    tp_obj.enterDescription("Creating a new user");
	}
	@When("User clicks on create customer button")
	public void user_clicks_on_create_customer_button() {
	    tp_obj.clickOnCreateCustomerBtn();
	}
	@Then("Verify new customer is created")
	public void verify_new_customer_is_created() {
		Assert.assertTrue(tp_obj.verifyNewCustomerIsCreated());
	}
	@When("User clicks on search field")
	public void user_clicks_on_search_field() {
	    tp_obj.clickOnSearchField();
	}
	@When("User enters customer name for search")
	public void user_enters_customer_name_for_search() {
		tp_obj.enterCustomerNameForSearch("xyz");
	}
	@When("User clicks on edit button of that customer")
	public void user_clicks_on_edit_button_of_that_customer() {
	    tp_obj.clickOnEditButton();
	}
	@When("User clicks on action button")
	public void user_clicks_on_action_button() {
	    tp_obj.clickOnActionBtn();
	}
	@When("User clicks on delete button")
	public void user_clicks_on_delete_button() {
	    tp_obj.clickOnDeleteBtn();
	}
	@When("User clicks on delete permanently button")
	public void user_clicks_on_delete_permanently_button() {
		tp_obj.clickOnDeletePermanentlyBtn();
	}
}

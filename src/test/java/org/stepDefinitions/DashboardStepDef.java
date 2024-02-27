package org.stepDefinitions;

import java.util.List;

import org.applicationHooks.AppHooks;
import org.pages.DashboardPage;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStepDef {
	private DashboardPage dpObj;
	
	@Then("Dashboard page is displayed")
	public void dashboard_page_is_displayed() {
		dpObj = new DashboardPage(AppHooks.driver);
		Assert.assertTrue(dpObj.isTimeTrackTabDisplayed());
		System.out.println("  -  Dashbord page is displayed");
		AppHooks.scn.log("Dashbord page is displayed");
	}
	
	@Then("Dashboard page title is displayed as {string}")
	public void dashboard_page_title_is_displayed_as(String expTitle) {
		Assert.assertEquals(dpObj.getDashboardPageTitle(), expTitle);
		System.out.println("  -  Dashboard page title is as expected");
		AppHooks.scn.log("Dashboard page title is as expected");
	}
	
	@Then("Dashboard page URL is displayed as {string}")
	public void dashboard_page_URL_is_displayed_as(String expURL) {
		Assert.assertEquals(dpObj.getDashboardPageURL(), expURL);
		System.out.println("  -  Dashboard page URL is as expected");
		AppHooks.scn.log("Dashboard page URL is as expected");
	}
	
	@Then("Dashboard displays {int} tabs")
	public void dashboard_displays_tabs(Integer expTabCount) {
		Assert.assertEquals(dpObj.getNumberOfDashboardTabs(), expTabCount);
		System.out.println("  -  Dashboard page displays 4 tabs");
		AppHooks.scn.log("Dashboard page displays 4 tabs");
	}
	
	@Then("{string} tab is by default selected")
	public void tab_is_by_default_selected(String expSelectedTabName) {
		Assert.assertTrue(dpObj.isTimeTrackTabSelected());
		System.out.println(expSelectedTabName + " tab is by default selected on Dashboard page");
		AppHooks.scn.log(expSelectedTabName + " tab is by default selected on Dashboard page");
	}
	
	@Then("Dashboard tab names {string}")
	public void dashboard_tab_names(String expAllTabNames) {
		String[] expTabNames = expAllTabNames.split(",");
		Assert.assertTrue(dpObj.verifyDashboardTabNames(expTabNames));
		System.out.println("  - Dashboard tab names are as expected");
		AppHooks.scn.log("Dashboard tab names are as expected");
	}
	
	@Then("User gets dashboard tabs")
	public void user_gets_dashboard_tabs(DataTable dataTable) {
		List<String> tabNames = dataTable.asList();
		String[] ar = tabNames.toArray(new String[0]);
		Assert.assertTrue(dpObj.verifyDashboardTabNames(ar));
		System.out.println("Dashboard tab names are as expected.");
	}
	
	@When("User clicks on tasks button")
	public void user_clicks_on_tasks_button() {
		dpObj.clickOnTasksBtn();
	}
	
	@When("User clicks on Users button")
	public void user_clicks_on_users_button() {
		dpObj.clickOnUsersTab();
	}
}

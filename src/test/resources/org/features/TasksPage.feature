Feature: Tasks page features

Background:
		Given User is on login page
			When User enters username
			And User enters password
			And User click on login button
			Then Dashboard page is displayed
			When User clicks on tasks button
			Then Tasks page is displayed
		
@smoke
Scenario: Add new customer
	  	When User clicks on add new button
	  	And User click on new customer button
	  	And User enters customer name
	  	And User enters description
	  	And User clicks on create customer button
	  	Then Verify new customer is created

@smoke
Scenario: Deleting a customer
			When User clicks on search field
			And User enters customer name for search
			And User clicks on edit button of that customer
			And User clicks on action button
			And User clicks on delete button
			And User clicks on delete permanently button
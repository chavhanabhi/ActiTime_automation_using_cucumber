Feature: Users page features

Background: 
		Given User is on login page
			When User enters username
			And User enters password
			And User click on login button
			Then Dashboard page is displayed
			When User clicks on Users button
			Then Users page is displayed
			
@regression
Scenario: Creating a user
			When User clicks on add user button
			And User enters firstname
			And User enters lastname
			And User enters email
			And User enters new username
			And User enters new password
			And User reenters password
			And User clicks on create user button
			 
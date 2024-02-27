Feature: Login page features

@smoke
Scenario: Verify login page URL
	Given User is on login page
		Then Login page URL is displayed as "http://localhost:93/login.do"

@smoke		
Scenario: Verify login page title
	Given User is on login page
		Then Login page title is displayed as "actiTIME - Login"

@regression
Scenario: Verify login page fields
	Given User is on login page
		Then Username field is displayed
		And Password field is displayed
		And Keep me login check box is displayed
		And Login logos are displayed
		And Login button is displayed

@regression @AMC-9876 @AMC-8864
Scenario: Verify login page functionality
	Given User is on login page
		When User enters username
		And User enters password
		And User click on login button
		Then Dashboard page is displayed
		
@regression
Scenario Outline: Verify login page functionality
	Given User is on login page
		When User enters <USERNAME> as username
		And User enters <PASSWORD> as password
		And User click on login button
		Then Dashboard page is displayed
	Examples:
		|USERNAME|PASSWORD|
		|"admin"|"manager"|
		|"admin"|"manager123"|
		|"admin123"|"manager"|
		|"admin123"|"manager123"|
		
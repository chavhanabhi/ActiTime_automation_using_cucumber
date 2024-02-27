Feature: Dashboard page features

Background:
		Given User is on login page
			When User enters username
			And User enters password
			And User click on login button
			Then Dashboard page is displayed

@smoke		
Scenario: Verify dashboard page title
		And Dashboard page title is displayed as "actiTIME - Enter Time-Track"
		
@smoke
Scenario: Verify dashboard page URL
		And Dashboard page URL is displayed as "http://localhost:93/user/submit_tt.do"

@regression
Scenario: Verify dashboard page tabs
		And Dashboard displays 4 tabs
		And "TIME-TRACK" tab is by default selected
		And Dashboard tab names "TIME-TRACK,TASKS,REPORTS,USERS"
		#And Dashboard tab names "TIME-TRACK","TASKS","REPORTS","USERS"
		
@regression
Scenario: Verify dashboard page tabs
		And Dashboard displays 4 tabs
		And "TIME-TRACK" tab is by default selected
		And User gets dashboard tabs
		|TIME-TRACK|
		|TASKS|
		|REPORTS|
		|USERS|
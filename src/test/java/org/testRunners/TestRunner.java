package org.testRunners;

// Run as TestNG test
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/org/features/LoginPage.feature",
				"src/test/resources/org/features/DashboardPage_Background.feature",
				"src/test/resources/org/features/TasksPage.feature",
				"src/test/resources/org/features/UsersPage.feature"},
		//features = {"src/test/resources/org/features/UsersPage.feature"},
		//features = {"src/test/resources/org/features/TasksPage.feature"},
		glue = {"org/stepDefinitions","org/applicationHooks"},
		monochrome = true,
		dryRun = false,
		//tags = "@regression"
		tags = "@regression or @smoke",
		//tags = "@regression and @smoke
		//format = {}     // for older cucumber versions used for reports
		// Now 'format' is replaced with 'plugin'
		plugin = {"pretty",
				"html:Reports/html/html_report.html",
				"json:Reports/json/json_report.json",
				"junit:Reports/junit/junit_report.xml",
				"rerun:Failed_Rerun/failedRerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
)
public class TestRunner extends AbstractTestNGCucumberTests{

}

// Run as JUnit 
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		////lots of cucumber options
//	)
//public class TestRunner {
//	
//}
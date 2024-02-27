package org.testRunners;

// Run as TestNG
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@Failed_Rerun/failedReRun.txt",
		glue = "org/stepDefinitions",
		monochrome = true,
		dryRun = false,
		//tags = "@regression",
		tags = "@regression or @smoke",
		//tags = "@regression and @smoke",
		//format = {}	//for older cucumber versions used for Reports
		//NOW, 'format' is replaced with 'plugin'
		plugin = {"pretty",
			"html:Reports/html/html_report.html",
			"json:Reports/json/json_report.json",
			"junit:Reports/junit/junit_report.xml"
		}
	)
public class Failed_TestRunner extends AbstractTestNGCucumberTests {

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
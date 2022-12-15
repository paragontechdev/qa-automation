package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/2022.07.19/Demo",
				"src/test/java/features/2022.08.2"
				}
		,glue = {"src/test/java/stepdefinitions"}
		,monochrome = true,
		plugin = {"pretty",
				 "junit:test-output/reports/JUnitReport.xml",
				 "json:test-output/reports/JSONReport.json",
				 "html:test-output/reports/HTMLReport.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		//dryRun = true
		)

public class TestRunner {}

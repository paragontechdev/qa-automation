package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features/UserExperienceQA"},
		glue = {"classpath:stepdefinitions"},
		tags = "@userexperience",
		plugin = {"pretty",
				 "junit:test-output/reports/JUnitReport.xml",
				 "json:test-output/reports/JSONReport.json",
				 "html:test-output/reports/HTMLReport.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		monochrome = true,
		dryRun = false
		)

public class TestRunner {
	
}

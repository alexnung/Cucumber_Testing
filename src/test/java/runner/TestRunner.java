package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cuke/task2.feature", plugin = {"pretty",
		"html:src/test/resources/reports/htmlReports", "json:src/test/resources/reports/jsonReports.json",
		"junit:src/test/resources/reports/xmlReport.xml" }, monochrome = true, glue = { "shopping" })

public class TestRunner {

}

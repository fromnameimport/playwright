package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\java\\Features\\general.feature",
        glue = {"StepDefinitions"},
        plugin = { "pretty", "html:reports/cucumber-reports.html" },
        monochrome = true
)
public class Run extends AbstractTestNGCucumberTests { }
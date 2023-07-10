package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\user\\IdeaProjects\\OrangeHRM\\src\\test\\java\\Features\\test.feature",
        glue = {"StepDefinitions"},
        plugin = { "pretty", "html:src/test/java/cucumber-reports.html" },
        monochrome = true
)
public class Run extends AbstractTestNGCucumberTests { }

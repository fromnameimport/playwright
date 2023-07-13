package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\user\\IdeaProjects\\OrangeHRM\\src\\test\\java\\Features\\general.feature",
//        tags = "@functional, @accessibility",
        glue = {"StepDefinitions"},
        plugin = { "pretty", "html:reports/cucumber-reports.html" },
        monochrome = true
)
public class Run extends AbstractTestNGCucumberTests { }

package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/rerun.txt", // Use @ to reference the file
        glue = "com.example.definitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-rerun-report.html",
                "json:target/cucumber-reports/cucumber-rerun-report.json"
        }
)
public class RerunFailedTests extends AbstractTestNGCucumberTests {
}
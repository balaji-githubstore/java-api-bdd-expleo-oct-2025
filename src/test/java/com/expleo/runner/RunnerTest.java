package com.expleo.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features/"}
        ,glue = {"com.expleo.steps","com.expleo.hooks"}
//        , dryRun = true
//        ,publish = true
//        ,plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"}
//        ,tags = "@regression or (not @valid and @smoke)"
        ,tags = "@chain4"
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}

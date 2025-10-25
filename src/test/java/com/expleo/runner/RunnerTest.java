package com.expleo.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features/CreateRepository.feature"}
        ,glue = {"com.expleo.steps"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}

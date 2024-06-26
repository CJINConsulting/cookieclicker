package com.airelogic.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"com.airelogic.steps"},
        monochrome = true,
        plugin = {"pretty", "html:target/reports/report.html"}
)
public class TestRunner {
}
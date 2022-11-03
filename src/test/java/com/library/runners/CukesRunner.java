package com.cydeo.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "src/test/resources/feature",
        glue = "com/cydeo/library/step_definitions",
        dryRun = false,
        publish = true,
        tags = ""



)

public class CukesRunner {
}

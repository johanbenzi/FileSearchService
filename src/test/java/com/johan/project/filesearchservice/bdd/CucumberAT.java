package com.johan.project.filesearchservice.bdd;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.johan.project.filesearchservice.bdd.steps" })
public class CucumberAT {
}
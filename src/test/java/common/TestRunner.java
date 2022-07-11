package common;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue= {"stepdefinitions"},monochrome = true,
plugin = {"pretty","html:target/HtmlReports"}, tags = "@SIT and not @smokeTest")
public class TestRunner {

}

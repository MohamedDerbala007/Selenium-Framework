package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "D:\\Testing courses and Work\\AutomationCourseWithSelenuim\\taf\\src\\test\\java\\features" 
, glue = {"steps"} 
, plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase 
{

}

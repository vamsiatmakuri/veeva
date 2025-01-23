package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/SampleTest.feature",
        glue = "com/bdd/stepdefinitions",
        plugin = { "pretty", "html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml" },
        monochrome = false
)
public class SequentialRunner extends AbstractTestNGCucumberTests {


}

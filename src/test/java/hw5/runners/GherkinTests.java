package hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/GherkinTests.feature"},
        glue = {"hw5.steps"}
)
public class GherkinTests extends AbstractTestNGCucumberTests {
}

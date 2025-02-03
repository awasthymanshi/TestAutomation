package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/Automation.feature",
        glue = "StepDef",
        tags = "@TC02",
        monochrome = true
)
public class Runner {
}

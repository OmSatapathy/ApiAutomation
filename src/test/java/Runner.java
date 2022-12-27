
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "junit:target/output.xml"},
        features = {"src/test/java/feature"},
        glue = {"defination"},
        monochrome = true)


public class Runner {
}

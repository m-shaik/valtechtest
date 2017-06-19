package stepdefs;

import common.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Muneer on 19/06/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@test",
        format = {"pretty","html:target/Destination"},
        features = {"src/test/resources/features"})
public class CucumberTestRunner {

    @BeforeClass
    public static void setup(){

        Driver.initialiseDriver();
    }

    @AfterClass
    public static void teardown(){

        Driver.driver.quit();
    }
}

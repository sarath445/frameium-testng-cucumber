package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features ={"src/test/resources/Features/DataGeneration.feature"},
        tags ="@mails",
        glue = {"StepDef"})

@RunWith(Cucumber.class)
public class Testrunner{
@BeforeClass
    public void beforeAll(){

}

@AfterClass
    public void AfterAll(){

}

}

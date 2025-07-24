package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features ={"src/test/resources/Features/DataGeneration.feature"},
        tags ="@mails",
        glue = {"StepDef"},
        monochrome = true)




public class Testrunner extends AbstractTestNGCucumberTests {
@BeforeClass
    public void beforeAll(){

}

@AfterClass
    public void AfterAll(){
    System.out.println("---TestSuite finished");


}

}

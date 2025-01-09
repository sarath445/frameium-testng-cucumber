package StepDef.Datageneration;

import PageObject.AutoDatageneration.Pageobject;
import com.testng.Utilities.Address.Addressutility;
import com.testng.Utilities.Email.Mailutility;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Datagenerationtestcucumber {
    private WebDriver driver;
    private Pageobject page;
    private String url = "https://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/input-form-demo.html";

    @Given("I am on the demoPage")
    public void iAmOnTheDemopage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.navigate().to(url);
        //creating object for the Pageobject class.
        page = new Pageobject(driver);
        //Addressutility.getrandomaddress();


    }

    @When("I enter a randomMail")
    public void iEnterARandommail() {
        Mailutility.genraterandommail();
        page.getrandommail(Mailutility.randommail);
        System.out.println("Generated random mail are " + Mailutility.randommail);
    }

    @Then("I should display the randomMail")
    public void iShouldDisplayTheRandommail(String email) {
        String enteredmail = page.getrandommail(email);
        Assert.assertEquals(enteredmail, Mailutility.randommail);
    }
    @After
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

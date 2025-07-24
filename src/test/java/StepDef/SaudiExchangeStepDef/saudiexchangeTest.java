package StepDef.SaudiExchangeStepDef;

import PageObject.SaudiExchange.Homepage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class saudiexchangeTest  {
    public WebDriver driver;
    private Homepage saudihome;

    public saudiexchangeTest(WebDriver driver){
        this.driver = driver;
       //this.saudihome = new Homepage(driver);

    }
//    @BeforeMethod
//    public void setUp(String url){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//        driver.manage().window().maximize();
//        driver.navigate().to(url);
//    }

    @When("User is on the {string} page")
    public void userIsOnThePage(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        saudihome= new Homepage(driver);
        saudihome.getUrl(url);
    }

    @When("User navigates to the Issuer financial calendar page")
    public void userNavigatesToTheIssuerFinancialCalendarPage() {
        saudihome.issueLander();
    }

    @Then("the Industry dropdown contain the following values")
    public void theIndustryDropdownContainTheFolllowingValues(DataTable datatable) {

        List<String> expectedOptions = datatable.asList();
        List<String> actualOptions = saudihome.getIndustrydropOptions();

        System.out.println("Expected: " + expectedOptions);
        System.out.println("Actual  : " + actualOptions);
        Assert.assertEquals(actualOptions, expectedOptions, "dropdown mmissmatch");
    }


}

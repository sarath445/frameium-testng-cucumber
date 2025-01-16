package StepDef.Datageneration;

import PageObject.AutoDatageneration.Datageneration;
import PageObject.AutoDatageneration.Pageobject;
import com.github.javafaker.Faker;
import com.testng.Utilities.Address.Addressutility;
import com.testng.Utilities.Currencies.Currencyutility;
import com.testng.Utilities.Email.Mailutility;
import com.testng.Utilities.SSN.SSNutility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class Datagenerationtest extends Datageneration {
    private WebDriver driver;
    private String url = "https://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/input-form-demo.html";
    private Pageobject page;
    private Currencyutility rupees;
    //private SSNutility ssn;





@BeforeClass()
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.navigate().to(url);
        //creating object for the Pageobject class.
         page = new Pageobject(driver);
         rupees = new Currencyutility();
         userneeddigits(5);
         Addressutility.getrandomaddress();
         Mailutility.genraterandommail();
         //generate random amount for currencies.
         rupees.genrateRandomAmounts();
         SSNutility.generateRandomSSN();

}
//throwing an expected exceptions.
@Test(expectedExceptions = {NoSuchElementException.class})

    public void testrandomnumber(){
       page.enterrandomnumber(randomnumbers);
       System.out.println("Test executed with random number: " + randomnumbers);
}

    @Given("user need Indianphonenumbers")
    public void userrandom(){
      String phonenum =  Datageneration.PhonenumberGenerator();
      System.out.println("generated numbers are: " + phonenum);

    }

@AfterClass
    public void teardown(){
    if(driver!=null){
        driver.quit();
    }
}

    @Then("user need random names")
    public void userNeedRandomNames() throws InterruptedException{
    String randomnames = Datageneration.RandomNameGenerator();
    System.out.println("generated randomnames are :" + randomnames);
    }

    @And("user need Usnumbers")
    public void userNeedUsnumbers() {
    String Usnumbers = Datageneration.UsnumberGenerator();
    System.out.println("generated Usnumbers are :" + Usnumbers);
    }

    @Then("user need randomdatepicking")
    public void userNeedRandomdatepicking() throws IOException {
    String randomdates = Datageneration.randomDatepicker();
    System.out.println(randomdates);

    }

    @Then("user need randomnumberdigits")
    public void userNeedRandomnumberdigits() {
        page.enterrandomnumber(randomnumbers);
        System.out.println("Test executed with random number: " + randomnumbers);
    }


@Test(expectedExceptions = {NoSuchElementException.class})
    public void userNeedRandomaddressnames() {
         page.enterrandomaddress(Addressutility.randomaddress);
         System.out.println("Generated random address are " + Addressutility.randomaddress);
    }

    @Test
    public void userNeedRandomdomainmail(){
        page.getrandommail(Mailutility.randommail);
        System.out.println("Generated random mail are " + Mailutility.randommail);
    }
@Test
    public void testRandomamountexistence() {
    for (Map.Entry<String, Double> entry : Currencyutility.currencyAmounts.entrySet())
        {
            String international = "currency: " + entry.getKey() + "amount" + entry.getValue();  //getting key and value from Map name.
            System.out.println(international);
        }

    }
    @Test
    public void randomSSNnum(){
        page.enterSSN(SSNutility.generateRandomSSN());
        System.out.println("Generated SSN are :" + SSNutility.generateRandomSSN());
    }


}


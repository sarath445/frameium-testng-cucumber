package StepDef.Datageneration;

import PageObject.AutoDatageneration.Datageneration;
import PageObject.AutoDatageneration.Pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Datagenerationtest extends Datageneration {
    private WebDriver driver;
    private String url = "https://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/input-form-demo.html";
    private Pageobject page;


@BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.navigate().to(url);
        //creating object for the Pageobject class.
         page = new Pageobject(driver);
         userneeddigits(3);

}

@Test
    public void testrandomnumber(){
       page.enterrandomnumber(randomnumbers);
       System.out.println("Test executed with random number: " + randomnumbers);
}

@AfterClass
    public void teardown(){
    if(driver!=null){
        driver.quit();
    }
}

}

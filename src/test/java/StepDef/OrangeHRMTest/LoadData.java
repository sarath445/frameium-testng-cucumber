package StepDef.OrangeHRMTest;

import PageObject.AutoDatageneration.Pageobject;
import PageObject.OrangeHRM.Loginhelper;
import TestngListener.ITestListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
@Listeners(ITestListeners.class)
public class LoadData {
    private WebDriver driver;
    private Pageobject page;
    private String url = "https://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/bootstrap-date-picker-demo.html";
    private String generate;
    @BeforeMethod
    public void Setup(@Optional("chrome")String browser) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));     //helps to handle Nosuchelement exception
        driver.navigate().to(url);
        driver.manage().window().maximize();
        page = new Pageobject(driver);

    }

    @Test(dataProvider = "pick data", dataProviderClass = Gettestdata.class)
    public void setdata(String date)throws InterruptedException {
        Thread.sleep(2000);
        String GeneratedDate = page.selectRandomdate(date);
        System.out.println(GeneratedDate);
        String enterDate = page.getRandom();
        Assert.assertEquals(GeneratedDate, enterDate, "Date doesn't match");
        Assert.assertTrue(page.Menutext(),"menu text is not available");




        //System.out.println(randomyear);
    }
}

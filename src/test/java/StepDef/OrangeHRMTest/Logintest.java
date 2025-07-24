package StepDef.OrangeHRMTest;

import Excelutility.DataExcel;
import PageObject.OrangeHRM.Loginhelper;
import TestngListener.ITestListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(ITestListeners.class)  //including all events are in this class and listening all methods in this class.
public class Logintest {

    private WebDriver driver;
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    Loginhelper login;


    @BeforeMethod
    @Parameters("url")
    public void Setup(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to(url);
        driver.manage().window().maximize();
        login = new Loginhelper(driver);

    }

   //@Test(description = "verify login", dataProvider = "logintestdatas3", dataProviderClass = LoginTestData.class)
//    public void logindatas(String username, String password) throws Exception {
//        login.Loginpage(username, password);
//        login.submitpage();
//    }

    @Test(description = "verifythelogin", dataProvider = "orangedatas", dataProviderClass = DataExcel.class)
    public void orangelogin(String username, String password) throws Exception {
        Thread.sleep(3000);
        login.Loginpage(username, password);
        Thread.sleep(3000);
        login.submitpage();
        Thread.sleep(8000);
        Assert.assertTrue(login.upgradebtn(), "upgrade button is not visible");
        //Assert.assertTrue((driver.findElement(By.xpath("//button[text()=' Upgrade']")).isDisplayed()));
    }

    @AfterMethod
    public void cleanup() {
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}

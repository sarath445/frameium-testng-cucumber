package StepDef.OrangeHRMTest;

import Excelutility.DataExcel;
import PageObject.Excelutillity.Exceldatas;
import PageObject.OrangeHRM.Loginhelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {

    private WebDriver driver;
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    Loginhelper login;




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        login = new Loginhelper(driver);

    }
    @Test(description = "verify login",dataProvider = "dp2",dataProviderClass = LoginTestData.class)
    public void logindatas(String username,String password)throws Exception{
        login.Loginpage(username, password);
        login.submitpage();
    }

    @Test(description = "verifythelogin", dataProvider = "getdata", dataProviderClass = DataExcel.class)
    public void orangelogin(String username, String password)throws Exception{
        login.Loginpage(username,password);
        login.submitpage();
        Thread.sleep(8000);
        Assert.assertTrue(login.upgradebtn(),"upgrade button is not visible");
        //Assert.assertTrue((driver.findElement(By.xpath("//button[text()=' Upgrade']")).isDisplayed()));
    }

    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }

    }
}

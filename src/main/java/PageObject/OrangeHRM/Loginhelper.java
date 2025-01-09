package PageObject.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginhelper {
    //initializing webdriver.
    private WebDriver driver;
    //locators.
    private By userOrange = By.xpath("//input[@name='username']");
    private By Passorange = By.xpath("//input[@name='password']");
    private By loginOrange = By.xpath("//button[text()=' Login ']");
    private By upgrade = By.xpath("//button[text()=' Upgrade']");


    //creating constructor.
    public Loginhelper(WebDriver driver){
        this.driver = driver;
    }
    //methods.
    public void Loginpage(String userName, String password)throws Exception{
        Thread.sleep(2000);
        WebElement Nameuser = driver.findElement(userOrange);
        Nameuser.sendKeys(userName);
        WebElement passWord = driver.findElement(Passorange);
        passWord.sendKeys(password);
        //wait for element to be visible and click
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.elementToBeClickable(loginOrange));
//        WebElement submitOrange = driver.findElement(loginOrange);
//        submitOrange.click();

    }
    public void submitpage(){
        //wait for element to be visible and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement submitelement = wait.until(ExpectedConditions.elementToBeClickable(loginOrange));
        submitelement.click();
    }
    public boolean upgradebtn(){
        boolean element = driver.findElement(upgrade).isDisplayed();
        return element;
    }
}

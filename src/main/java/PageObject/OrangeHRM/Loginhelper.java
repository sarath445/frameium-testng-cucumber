package PageObject.OrangeHRM;

import org.openqa.selenium.*;
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
        Thread.sleep(4000);
        WebElement nameUser = driver.findElement(userOrange);
        nameUser.sendKeys(userName);
        WebElement passWord = driver.findElement(Passorange);
        passWord.sendKeys(password);
        //wait for element to be visible and click
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.elementToBeClickable(loginOrange));
//        WebElement submitOrange = driver.findElement(loginOrange);
//        submitOrange.click();

    }
    public void submitpage(){
        //wait for element to be visible and click, like as explicit wait condition.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        //using try-catch to handle exceptions for avoiding program crashes.
        try{
            WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(loginOrange));
            submitElement.click();
        }
        catch (StaleElementReferenceException e){
            System.out.println("Element became stale. Retrying...");
            WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(loginOrange));
            submitElement.click();
        }

    }
    public boolean upgradebtn(){
        try{
           return driver.findElement(upgrade).isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }

    }
}

package PageObject.AutoDatageneration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pageobject {
    WebDriver driver;

//initilaizing constructor.
    public Pageobject(WebDriver driver){
        this.driver=driver;

    }

    private By inputfield = By.xpath("//input[@name='phone']");
    private By demoaddress = By.xpath("//input[@name='address']");
    private By demomail = By.xpath("//input[@name='email']");
    private By demoSSN = By.xpath("//input[@name='zip']");
    private By calendar = By.cssSelector("datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom");
    private By demodate = By.xpath("//input[@placeholder = 'dd/mm/yyyy']");
    private By menu = By.xpath("//div[text()='Menu List']");

    public void enterrandomnumber(String randomnumber){
        WebElement phone = driver.findElement(inputfield);
        phone.sendKeys(randomnumber);

    }

    public void enterrandomaddress(String Address){
        WebElement address = driver.findElement(demoaddress);
        address.sendKeys(Address);
        driver.findElement(By.id("welocome")).click();
    }

    public String getrandommail(String email){
        WebElement mail = driver.findElement(demomail);
        mail.sendKeys(email);
        return mail.getAttribute("value");
    }

    public void enterSSN(String ssn){
        WebElement ssnelement = driver.findElement(demoSSN);
        ssnelement.sendKeys(ssn);
    }
    //creating method of one-dimensional array.
    public String selectRandomdate(String dates){
        WebElement selectdate = driver.findElement(demodate);
        selectdate.sendKeys(dates);
        return  selectdate.getAttribute("value");
    }

    public String getRandom(){
        WebElement selectdate = driver.findElement(demodate);
        return selectdate.getAttribute("value");
    }
    public boolean Menutext(){
        try {
            return driver.findElement(menu).isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
   
}

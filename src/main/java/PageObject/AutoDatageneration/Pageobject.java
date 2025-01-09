package PageObject.AutoDatageneration;

import org.openqa.selenium.By;
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
        return mail.getAttribute(email);
    }

}

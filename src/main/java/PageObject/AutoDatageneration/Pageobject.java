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

    public void enterrandomnumber(String randomnumber){
        WebElement phone = driver.findElement(inputfield);
        phone.sendKeys(randomnumber);

    }
}

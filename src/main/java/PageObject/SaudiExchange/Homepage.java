package PageObject.SaudiExchange;

import com.aventstack.extentreports.util.Assert;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.collections4.functors.ExceptionPredicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {
    public WebDriver driver;
    WebDriverWait wait;

    public Homepage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(100));
    }

    public void getUrl(String url){
        driver.navigate().to(url);

    }

    public void issueLander(){
        WebElement markele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[(contains(text(),'Market News & Reports'))]")));
        markele.click();
        WebElement issueEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[(contains(text(),'Issuer Financial Calendars'))]")));
        issueEle.click();
    }

    public List<String> getIndustrydropOptions(){
        WebElement dropdownEle = driver.findElement(By.id("sector"));
        Select select = new Select(dropdownEle);
        List<WebElement> marketOptions = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        for(WebElement options : marketOptions){
            optionTexts.add(options.getText());

        }
          return optionTexts;

    }

    public void vfyIndustrydropOptions(DataTable expectedData){
        List<String> expectedOptions = expectedData.asList();
        List<String> actualOptions = getIndustrydropOptions();

        System.out.println("Expected: " + expectedOptions);
        System.out.println("Actual  : " + actualOptions);



    }
    }


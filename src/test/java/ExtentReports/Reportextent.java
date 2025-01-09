package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Reportextent {
    static WebDriver driver;
    static String url = "https://www.google.co.in/";
    //main method.
    public static void main(String[]args)throws Exception  {
        ExtentReports extent = new ExtentReports();
        //String instance & File instance.
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extent.attachReporter(sparkReporter);
        //setting up the driver and navigate to the google page.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        String path = capturescreenshot("Google.jpg");


        ExtentTest test = extent.createTest("Test1");
        test.pass("this is passed");
        ExtentTest test2 = extent.createTest("test2");
        test2.log(Status.PASS, "this is successful");

        extent.createTest("test3")
                .log(Status.FAIL, "this is failed")
                        .log(Status.INFO, "<b>Information</b>")
                                .log(Status.WARNING, "there is danger ahead")
                                        .log(Status.SKIP, "please skip the case");
        extent.createTest("Screenshot at testlevel", "this is for attatching the screenshot at testlevel")
                        .info("This is Info message")
                                .addScreenCaptureFromPath(path, "Google homepage");

        extent.createTest("testcase","this is for attatching screenshot")
                        .pass("hurray! it's passed")
                                .fail("This is failmessage",MediaEntityBuilder.createScreenCaptureFromPath(path,"Googlepage").build());

        extent.flush();
        driver.quit();
        //for getting and displaying report on automatically.
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }

    //method for getting screenshot and settup the localpath for storing the screenshots.
    public static String capturescreenshot(String filename)throws IOException{
        TakesScreenshot takescreen = (TakesScreenshot) driver;
        File sourcefile = takescreen.getScreenshotAs(OutputType.FILE);
        File destfile = new File("./Screenshots/" + filename );
        try {
            FileUtils.copyFile(sourcefile, destfile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return destfile.getAbsolutePath();
    }
}
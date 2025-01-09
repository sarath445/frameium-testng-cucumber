package PageObject.AutoDatageneration;

import com.testng.Utilities.Address.Addressutility;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class Datageneration  {
    //setting the global variables.
    protected static String randomnumbers;
    //protected static String randomaddress;
    //locating elements.




    public static String userneeddigits(int length){
        Random random = new Random();
        int min = (int) Math.pow(10, length-1);
        int max = (int) Math.pow(10, length)-1;
        int numbers = random.nextInt((max - min) + 1);
        randomnumbers = String.valueOf(numbers);
        return randomnumbers;
    }

    public static String PhonenumberGenerator(){
        //creating Random class.
        Random random = new Random();
        int firstdigit = random.nextInt(9) + 1;  //generates a number b/w 1 and 9
        long remainingdigits = (long)(random.nextDouble()*1_000_000_000L);

        String phonenumber  = firstdigit + String.format("%09d", remainingdigits );

        return  "+91" + phonenumber;
    }

    public static String RandomNameGenerator()throws InterruptedException{
        Thread.sleep(2000);
        //int length = 10; //Length of the random names.
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  // alphabetic characters.
        Random random = new Random();
        StringBuilder formnames = new StringBuilder();
        for(int m=0; m<10; m++){
            int index = random.nextInt(alphabet.length()); //Get a random index.
            formnames.append(alphabet.charAt(index)); //appending/adding character to the index by using Stringbuilder name.
        }
        return formnames.toString();
    }

    public static String UsnumberGenerator(){
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        int areacode = 200 + random.nextInt(300); //generates a random number between 0 & 299.
        int centralofficecode = 200 + random.nextInt(600);
        int localcodes = 2000 + random.nextInt(9999);
        code.append("+1").append(areacode).append(centralofficecode).append(localcodes);
        return code.toString();
    }

    public static String randomDatepicker()throws IOException {
        Random random = new Random();
        TimeZone time = TimeZone.getDefault();
        String timeID = time.getID();
        LocalTime local = LocalTime.now();
        //Date randomdates = new Date();
        //String dateformat = "dd/mm/yy";
        //generate a random year b/w 2000 - 2024
        int year = 2000 +  random.nextInt(24);
        int month = 1 + random.nextInt(12);
        //creating Calendar class method.
        Calendar day = Calendar.getInstance();
        day.set(Calendar.YEAR, year);  //int field & int value.
        day.set(Calendar.MONTH, month);

        //fetching maximum days in a month.
        int maxday = day.getActualMaximum(Calendar.DAY_OF_MONTH);
        //generating a day in a month. (1 to maxday).
        int date = 1 +  random.nextInt(maxday);
        //set the random day in the calendar.
        day.set(Calendar.DAY_OF_MONTH, date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateformated = dateFormat.format(day.getTime());
        return (dateformated+ " \n " +timeID + local);

    }

    public void randomnuberexecel()throws Exception{
        Random random = new Random();
        //path of excel file.
        String excelfilepath = "C:\\Users\\THIC2110733\\Frameium\\src\\main\\java\\com\\frameium\\Excel";
        //open the excel.
        FileInputStream fis = new FileInputStream(new File(excelfilepath));
        Workbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

    }

    public void Randomaddress(){

    }

}

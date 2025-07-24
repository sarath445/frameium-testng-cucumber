package StepDef.OrangeHRMTest;

import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Gettestdata {
    @DataProvider(name = "pick data")
    public Object[][] getdata(){
        int startyear = 1990;
        int endyear = 2025;
        Random random = new Random();   // creating instance for Random.
        int randomyear = random.nextInt(startyear, endyear);
        System.out.println(randomyear);
        int days = random.nextInt(31) + 1;   //generating random days between 1 and 31.
        System.out.println("random day are :" + days);
        int month = random.nextInt(12) + 1;       //generating random month between 1 and 12.
        System.out.println("random month are :" + month);
        String formatDate = days + "/" + month + "/" + randomyear;    //converted to String form.
        System.out.println("formated " + formatDate);
        return new Object[][]{ {formatDate} };


    }
    public static String formatedDate(String format){
        Random random = new Random();
        int randomdays = random.nextInt(365);
        LocalDateTime randomdate = LocalDateTime.now().minusDays(randomdays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return randomdate.format(formatter);
    }


}

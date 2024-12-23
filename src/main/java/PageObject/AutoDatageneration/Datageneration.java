package PageObject.AutoDatageneration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Datageneration {
    protected static String randomnumbers;
    //locating elements.




    public static String userneeddigits(int length){
        Random random = new Random();
        int min = (int) Math.pow(10, length-1);
        int max = (int) Math.pow(10, length)-1;
        int numbers = random.nextInt((max - min) + 1);
        randomnumbers = String.valueOf(numbers);
        return randomnumbers;
    }


}

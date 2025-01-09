package com.testng.Utilities.Currencies;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Currencyutility {
    public static Map<String,Double> currencyAmounts = new HashMap<>();

    public void genrateRandomAmounts() {
        Random random = new Random();
        String[] currencies = {"USD", "INR", "EUR", "PAK", "AUD", "AED"};
        //generate random amount and store in the map
        for (String currency : currencies) {
            double randomamount = random.nextDouble(10,1000); //storing values from 10 to 1000.
            currencyAmounts.put(currency, randomamount); //key and values
        }
    }





    //        Faker faker = new Faker();
//        String currency = faker.currency().code();
//
//        random.nextDouble(10,2000);

}

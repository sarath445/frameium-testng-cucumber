package com.testng.Utilities.Address;

import com.github.javafaker.Faker;

public class Addressutility {
    public static String randomaddress;
     //private static final Faker faker = new Faker();

    //method to return the variable of Faker by full address.
    public static void getrandomaddress(){
        Faker faker = new Faker();
        randomaddress = faker.address().fullAddress();
        //return faker.address().fullAddress();
    }

}

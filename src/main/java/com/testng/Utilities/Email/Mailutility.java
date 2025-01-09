package com.testng.Utilities.Email;

import com.github.javafaker.Faker;
import com.testng.Test;

import java.util.Random;

public class Mailutility {

    public static String randommail;

    //generate and store random mail with different domain.
    public static void genraterandommail(){
        Faker faker = new Faker();
        String username = faker.internet().emailAddress().split("@")[0]; //generate random username.
        //String username = faker.name().firstName().split("@")[0];
        String[] domain = {"example.com", "test.org","sample.net", "demo.io", "test.ng"}; //different domains.
        String diffdomain = domain[new Random().nextInt(domain.length)]; //generate a random domains.
        randommail = username + "@" + diffdomain;

    }

}

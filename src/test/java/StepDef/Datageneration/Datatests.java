package StepDef.Datageneration;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Datatests {
    private WebDriver driver;

    @Test
    public void maildata(){
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@gmail.com";
        System.out.println(email);

    }
}

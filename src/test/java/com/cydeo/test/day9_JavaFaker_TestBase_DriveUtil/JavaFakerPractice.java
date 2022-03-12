package com.cydeo.test.day9_JavaFaker_TestBase_DriveUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.letterify(\"??????\") = " + faker.letterify("??????"));
        System.out.println("faker.bothify(\"??#??#??###\") = " + faker.bothify("??#??#??###"));

    }
}

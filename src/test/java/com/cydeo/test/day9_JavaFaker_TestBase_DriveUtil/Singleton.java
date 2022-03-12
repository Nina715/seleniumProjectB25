package com.cydeo.test.day9_JavaFaker_TestBase_DriveUtil;

public class Singleton {
    //create private constructor to prevent access from outside the class
    private Singleton() {
    }

    //create private static string to prevent access from outside the class
    private static String word;

    public static String getWord() {
        if (word == null) {
            System.out.println("First Time call. Word Object is null. Assigning value to it now!");

            word = "something";
        } else {
            System.out.println("word already has value");
        }


        return word;
    }
}

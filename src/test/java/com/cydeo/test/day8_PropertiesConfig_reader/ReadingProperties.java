package com.cydeo.test.day8_PropertiesConfig_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_test() throws IOException {
        //create the object of Properties
        Properties properties = new Properties();

        // open file in java memory
        FileInputStream file = new FileInputStream("configuration.properties");

        //load properties object using FileInputStream Object
        properties.load(file);

        // use properties object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));


    }
}

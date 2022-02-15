package com.cydeo.test.day5_TestNGintro_dropdown;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TestNG_Intro {

    @Test (priority = 1)// this test is runnable now without main method, also now this will be the first method to run b4 the other test
    public void test1(){
        System.out.println("Test 1 is running");

        //Assert Equals: compare 2 of the same things
       assertEquals("actual","actual"); // passing two strings //statically imported all the static contributors from Assert class
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running");
        String actual = "apple";
        String expected = "apple";
        assertTrue(actual.equals(expected));
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("after method is running<--");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("-----> before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running <-----");
    }


/* all tests will pass if there are no assertion, the only time it will fail is that you insert some conditions/assertions*/
}

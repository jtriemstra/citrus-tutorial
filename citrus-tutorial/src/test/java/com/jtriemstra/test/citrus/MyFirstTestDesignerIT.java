package com.jtriemstra.test.citrus;

import org.testng.annotations.Test;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;

@Test
public class MyFirstTestDesignerIT extends TestNGCitrusTestDesigner {
    @CitrusTest(name = "MyFirstTest")
    public void myFirstTest() {
        description("First example showing the basic test case definition elements!");

        variable("text", "Hello Test Framework");

        echo("${text}");
    }
    
    @CitrusTest(name = "MyFirstTest println")
    public void myFirstTestPrintln() {
        description("First example showing the basic test case definition elements!");
        echo("Starting test");
        
        variable("text", "Hello Test Framework");
        System.out.println("Dumping something to command line");
        echo("${text}");
    }
}

package com.jtriemstra.test.citrus;

import org.testng.annotations.Test;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;

@Test
public class MyFirstTestRunnerIT extends TestNGCitrusTestRunner  {
    @CitrusTest(name = "MyFirstTestRunner")
    public void myFirstTest() {
        description("First example showing the basic test case definition elements!");

        variable("text", "Hello Test Framework");

        echo("${text}");
    }

    @CitrusTest(name = "MyFirstTestRunner println")
    public void myFirstTestPrintln() {
        description("First example showing the basic test case definition elements!");
        echo("Starting test");
        
        variable("text", "Hello Test Framework");
        System.out.println("Dumping something to command line");
        echo("${text}");
    }
}

package com.jtriemstra.test.citrus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;

@Test
public class MyFirstTestRunnerIT extends TestNGCitrusTestRunner  {
	
	Log log = LogFactory.getLog(this.getClass());
	
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

    @CitrusTest(name = "MyFirstTestRunner log")
    public void myFirstTestLog() {
        description("First example showing the basic test case definition elements!");
        echo("Starting test");
        
        variable("text", "Hello Test Framework");
        log.info("Dumping something to the log");
        echo("${text}");
    }
}

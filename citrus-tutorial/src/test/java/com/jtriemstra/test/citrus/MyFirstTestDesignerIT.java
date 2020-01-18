package com.jtriemstra.test.citrus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;

@Test
public class MyFirstTestDesignerIT extends TestNGCitrusTestDesigner {
	
	Log log = LogFactory.getLog(this.getClass());
	
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

    @CitrusTest(name = "MyFirstTest log")
    public void myFirstTestLog() {
        description("First example showing the basic test case definition elements!");
        echo("Starting test");
        
        variable("text", "Hello Test Framework");
        log.info("Dumping something to the log");
        echo("${text}");
    }
}

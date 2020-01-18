package com.jtriemstra.test.citrus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;

import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

@Test
@Configuration
public class JsonTestRunnerIT extends TestNGCitrusTestRunner  {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
    private HttpClient jsonClient;

    @Test
    @CitrusTest
    public void testGet() {
        http(httpActionBuilder -> httpActionBuilder
            .client(jsonClient)
            .send()
            .get("/")
            .accept("application/json"));

        http(httpActionBuilder -> httpActionBuilder
            .client(jsonClient)
            .receive()
            .response(HttpStatus.OK)
            .messageType(MessageType.JSON)
            .validate("$.date", "01-18-2020")
            .validate("$.time", "@ignore(11)@")
            .validate("$.milliseconds_since_epoch", "@ignore@"));
            //.xpath("//xh:h1", "TODO list")
            /*.payload("{\"date\": \"@ignore(10)@\",\r\n" + 
            		"   \"milliseconds_since_epoch\": @ignore@,\r\n" + 
            		"   \"time\": \"@ignore(11)@\"}"));*/
    }

    /*@Bean
    public HttpClient exampleClient() {
        return CitrusEndpoints
            .http()
                .client()
                .requestUrl("http://www.example.com")
            .build();
    }*/
}

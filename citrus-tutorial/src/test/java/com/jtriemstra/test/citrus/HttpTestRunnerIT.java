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
public class HttpTestRunnerIT extends TestNGCitrusTestRunner  {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
    private HttpClient exampleClient;

    @Test
    @CitrusTest
    public void testGet() {
        http(httpActionBuilder -> httpActionBuilder
            .client(exampleClient)
            .send()
            .get("/")
            .accept(MediaType.TEXT_HTML_VALUE));

        http(httpActionBuilder -> httpActionBuilder
            .client(exampleClient)
            .receive()
            .response(HttpStatus.OK)
            .messageType(MessageType.PLAINTEXT)
            //.xpath("//xh:h1", "TODO list")
            .payload("<!doctype html>\r\n" + 
            		"<html>\r\n" + 
            		"<head>@ignore@" +
            		"</head>\r\n" + 
            		"\r\n" + 
            		"<body>@ignore@\r\n" +             		
            		"</body>\r\n" + 
            		"</html>\r\n" + 
            		""));
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

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
            		"<head>\r\n" + 
            		"    <title>Example Domain</title>\r\n" + 
            		"\r\n" + 
            		"    <meta charset=\"utf-8\" />\r\n" + 
            		"    <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\r\n" + 
            		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
            		"    <style type=\"text/css\">\r\n" + 
            		"    body {\r\n" + 
            		"        background-color: #f0f0f2;\r\n" + 
            		"        margin: 0;\r\n" + 
            		"        padding: 0;\r\n" + 
            		"        font-family: -apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
            		"        \r\n" + 
            		"    }\r\n" + 
            		"    div {\r\n" + 
            		"        width: 600px;\r\n" + 
            		"        margin: 5em auto;\r\n" + 
            		"        padding: 2em;\r\n" + 
            		"        background-color: #fdfdff;\r\n" + 
            		"        border-radius: 0.5em;\r\n" + 
            		"        box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);\r\n" + 
            		"    }\r\n" + 
            		"    a:link, a:visited {\r\n" + 
            		"        color: #38488f;\r\n" + 
            		"        text-decoration: none;\r\n" + 
            		"    }\r\n" + 
            		"    @media (max-width: 700px) {\r\n" + 
            		"        div {\r\n" + 
            		"            margin: 0 auto;\r\n" + 
            		"            width: auto;\r\n" + 
            		"        }\r\n" + 
            		"    }\r\n" + 
            		"    </style>    \r\n" + 
            		"</head>\r\n" + 
            		"\r\n" + 
            		"<body>\r\n" + 
            		"<div>\r\n" + 
            		"    <h1>Example Domain</h1>\r\n" + 
            		"    <p>This domain is for use in illustrative examples in documents. You may use this\r\n" + 
            		"    domain in literature without prior coordination or asking for permission.</p>\r\n" + 
            		"    <p><a href=\"https://www.iana.org/domains/example\">More information...</a></p>\r\n" + 
            		"</div>\r\n" + 
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

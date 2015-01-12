package com.application.web.integration.test;

import static org.junit.Assert.assertEquals;

import com.application.web.test.Utils;
import com.google.gson.JsonParser;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleRSIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleRSIT.class);

    private static final JsonParser PARSER = new JsonParser();

    @Test
    public void testCase() throws ClientProtocolException, IOException {

        LOGGER.info("Executing GET JSON request");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8080/app/rs/example");

        CloseableHttpResponse response = client.execute(get);

        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("Awesome content from server goes here", getResponse(response));
    }

    private String getResponse(HttpResponse resp) throws IllegalStateException, IOException {

        String respTxt = Utils.getStringFromInputStream(resp.getEntity().getContent());

        return PARSER.parse(respTxt).getAsJsonObject().get("response").getAsString();
    }

}

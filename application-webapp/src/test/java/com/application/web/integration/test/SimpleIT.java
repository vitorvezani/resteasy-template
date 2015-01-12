package com.application.web.integration.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleIT.class);

    @Test
    public void testCase() throws ClientProtocolException, IOException {

        LOGGER.info("Executing homepage GET request");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8080/app");

        CloseableHttpResponse response = client.execute(get);

        assertEquals(200, response.getStatusLine().getStatusCode());
    }

}

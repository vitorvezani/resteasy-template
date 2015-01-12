package com.application.business.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTest.class);

    @Test
    public void testCase() {

        LOGGER.info("Testing the business module");
    }

}

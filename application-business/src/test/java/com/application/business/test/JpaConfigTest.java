package com.application.business.test;

import static org.junit.Assert.assertNotNull;

import com.application.business.jpa.EntityManagerFactoryWrapper;

import javax.persistence.EntityManager;

import org.junit.Test;

public class JpaConfigTest {

    @Test
    public void testConfiguration() {

        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        assertNotNull(em);
    }

}

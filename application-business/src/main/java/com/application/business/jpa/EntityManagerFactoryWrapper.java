package com.application.business.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;
import javax.swing.JFrame;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hsqldb.util.DatabaseManagerSwing;

public class EntityManagerFactoryWrapper {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private EntityManagerFactoryWrapper() {

        super();
    }

    private static EntityManagerFactory getFactory() {

        if (emf == null) {

            //fixHibernateBug();
            emf = Persistence.createEntityManagerFactory("application-memory-pu");

            if (System.getProperty("execute.database.manager") != null) {
                try {
                    executeDatabaseManager();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return emf;
    }

    public static EntityManager getEntityManager() {

        if (em == null) {
            em = getFactory().createEntityManager();
        }
        return em;
    }

    private static void executeDatabaseManager() throws Exception {

        String title = "Memory database manager";

        DatabaseManagerSwing manager = new DatabaseManagerSwing(new JFrame(title));
        manager.main();

        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "sa", "");
        manager.connect(con);

        manager.start();
    }

    /**
     * There is a bug within hibernate 4.3.7.Final
     * 
     * https://hibernate.atlassian.net/browse/HHH-9141
     */
     /*
     private static void fixHibernateBug() {

        PersistenceProviderResolverHolder.setPersistenceProviderResolver(new PersistenceProviderResolver() {

            private final List<PersistenceProvider> providers = Arrays.asList(new HibernatePersistenceProvider());

            public List<PersistenceProvider> getPersistenceProviders() {

                return providers;
            }

            public void clearCachedProviders() {

                providers.clear();
            }
        });
    }
    */

}

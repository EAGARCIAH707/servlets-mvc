
package com.andevs.crudmvc.model.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersistenceConfig {
    private static SessionFactory sessionFactory;

    private static void createSetSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("database connect");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSetSessionFactory();
            return sessionFactory;
        }
        return sessionFactory;
    }
}

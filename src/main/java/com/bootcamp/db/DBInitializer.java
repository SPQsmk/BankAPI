package com.bootcamp.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DBInitializer implements Initializer {
    private final String initPath = "src/main/resources/db/init.sql";
    private final String fillPath = "src/main/resources/db/fill.sql";
    private final SessionFactory factory;

    public DBInitializer(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void init() {
        executeScript(initPath);
    }

    @Override
    public void fill() {
        executeScript(fillPath);
    }

    private void executeScript(String path) {
        try {
            String script = new String(Files.readAllBytes(Paths.get(path)));

            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.createNativeQuery(script).executeUpdate();
                session.getTransaction().commit();
            } catch (PersistenceException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

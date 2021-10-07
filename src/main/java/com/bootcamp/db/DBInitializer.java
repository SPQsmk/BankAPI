package com.bootcamp.db;

import org.hibernate.SessionFactory;

public class DBInitializer implements Initializer {
    private final String createPath = "src/main/resources/db/init.sql";
    private final String fillPath = "src/main/resources/db/fill.sql";
    private SessionFactory factory;

    public DBInitializer(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void init() {

    }

    @Override
    public void fill() {

    }
}

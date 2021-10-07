package com.bootcamp.service;

import com.bootcamp.db.DBInitializer;
import com.bootcamp.db.Initializer;
import com.bootcamp.db.dao.CardDAO;
import com.bootcamp.db.dao.CardDAOImpl;
import com.bootcamp.model.Account;
import com.bootcamp.model.Card;
import com.bootcamp.model.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CardServiceImpl implements CardService {
    private static CardServiceImpl instance;

    private SessionFactory factory;
    private Initializer initializer;
    private CardDAO cardDAO;

    private CardServiceImpl() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Card.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        initializer = new DBInitializer(factory);
        cardDAO = new CardDAOImpl(factory);
    }

    public static CardServiceImpl getInstance() {
        CardServiceImpl result = instance;

        if (result != null) {
            return result;
        }

        synchronized(CardServiceImpl.class) {
            if (instance == null) {
                instance = new CardServiceImpl();
            }

            return instance;
        }
    }


}

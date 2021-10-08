package com.bootcamp.service;

import com.bootcamp.db.DBInitializer;
import com.bootcamp.db.Initializer;
import com.bootcamp.db.dao.CardDAO;
import com.bootcamp.db.dao.CardDAOImpl;
import com.bootcamp.model.Account;
import com.bootcamp.model.Card;
import com.bootcamp.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CardServiceImpl implements CardService {
    private static CardServiceImpl instance;

    private final CardDAO cardDAO;

    private CardServiceImpl() {
        SessionFactory factory = getFactory();
        cardDAO = new CardDAOImpl(factory);
        initAndFillDB(factory);
    }

    private SessionFactory getFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Card.class)
                .buildSessionFactory();
    }

    private void initAndFillDB(SessionFactory factory) {
        Initializer initializer = new DBInitializer(factory);
        initializer.init();
        initializer.fill();
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

    public void getCards() {
        try (Session session = getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("SELECT d FROM Client d LEFT JOIN FETCH d.accountList WHERE d.id = 2", Client.class).getResultList().forEach(System.out::println);
            Client account = session.get(Client.class, 2L);
            account.getAccountList().forEach(System.out::println);
        }
    }
}

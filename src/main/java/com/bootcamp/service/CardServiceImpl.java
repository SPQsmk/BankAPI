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
    private final CardDAO cardDAO;

    public CardServiceImpl() {
        SessionFactory factory = getFactory();
        cardDAO = new CardDAOImpl(factory);
        initAndFillDB(factory);
    }

    private SessionFactory getFactory() {
        return new Configuration().configure()
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

//    public void getCards() {
//        try (Session session = getFactory().openSession()) {
//            session.beginTransaction();
//            Client client = session.get(Client.class, 2L);
//            for (Account account : client.getAccountList()) {
//                for (Card c : account.getCardList())
//                    System.out.println(account + " : " + c);
//            }
//        }
//    }
}

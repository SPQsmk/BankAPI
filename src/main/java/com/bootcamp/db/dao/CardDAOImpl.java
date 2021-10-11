package com.bootcamp.db.dao;

import com.bootcamp.model.Card;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class CardDAOImpl implements CardDAO{
    private final SessionFactory factory;

    public CardDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void depositMoney(Card from, Card to, BigDecimal sum) {

    }

    @Override
    public BigDecimal getBalance(Card card) {
        return null;
    }
}

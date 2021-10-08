package com.bootcamp.db.dao;

import com.bootcamp.model.Account;
import com.bootcamp.model.Card;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.List;

public class CardDAOImpl implements CardDAO{
    private final SessionFactory factory;

    public CardDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Card card) {

    }

    @Override
    public List<Card> getCards(Account account) {
        return null;
    }

    @Override
    public void depositMoney(Card card, BigDecimal sum) {

    }

    @Override
    public BigDecimal getBalance(Card card) {
        return null;
    }
}

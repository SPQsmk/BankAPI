package com.bootcamp.db.dao;

import com.bootcamp.model.Account;
import com.bootcamp.model.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardDAO {
    void create(Card card);
    List<Card> getCards(Account account);
    void depositMoney(Card card, BigDecimal sum);
    BigDecimal getBalance(Card card);
}

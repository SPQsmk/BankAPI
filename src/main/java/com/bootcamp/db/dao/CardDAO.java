package com.bootcamp.db.dao;

import com.bootcamp.model.Card;

import java.math.BigDecimal;

public interface CardDAO {
    void depositMoney(Card from, Card to, BigDecimal sum);
    BigDecimal getBalance(Card card);
}

package com.bootcamp.dao;

import com.bootcamp.entity.Card;

import java.util.List;

public interface ClientDAO {
    List<Card> getCards(Long clientId);
}

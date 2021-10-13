package com.bootcamp.dao;

import com.bootcamp.entity.Card;

import java.util.List;

public interface ClientDAO {
    /**
     * Get list of cards from DB by client id
     * @param clientId
     * @return list of cards
     */
    List<Card> getCards(Long clientId);
}

package com.bootcamp.dao;

import com.bootcamp.dto.CreateCardDTO;

public interface CardDAO {
    /**
     * Saves the card to the DB
     * @param createCardDTO - contains account id and card number
     */
    void createCard(CreateCardDTO createCardDTO);
}

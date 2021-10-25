package com.bootcamp.service;

import com.bootcamp.dto.CreateCardDTO;

public interface CardService {
    /**
     * Saves the card to the datasource
     * @param createCardDTO - contains account id and card number
     */
    void createCard(CreateCardDTO createCardDTO);
}

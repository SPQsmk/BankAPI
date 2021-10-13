package com.bootcamp.service;

import com.bootcamp.dto.CardDTO;

import java.util.List;

public interface ClientService {
    /**
     * Get list of cards from datasource by client id
     * @param clientId
     * @return list of cards
     */
    List<CardDTO> getCards(Long clientId);
}

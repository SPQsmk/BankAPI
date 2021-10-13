package com.bootcamp.service;

import com.bootcamp.dto.CardDTO;

import java.util.List;

public interface ClientService {
    List<CardDTO> getCards(Long clientId);
}

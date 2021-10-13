package com.bootcamp.service;

import com.bootcamp.dao.CardDAO;
import com.bootcamp.dto.CreateCardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {
    private final CardDAO cardDAO;

    public CardServiceImpl(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Override
    @Transactional
    public void createCard(CreateCardDTO createCardDTO) {
        cardDAO.createCard(createCardDTO);
    }
}

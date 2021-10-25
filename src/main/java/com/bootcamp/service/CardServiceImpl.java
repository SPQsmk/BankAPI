package com.bootcamp.service;

import com.bootcamp.dao.CardDAO;
import com.bootcamp.dto.CreateCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {
    private final CardDAO cardDAO;

    @Autowired
    public CardServiceImpl(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Override
    @Transactional
    public void createCard(CreateCardDTO createCardDTO) {
        cardDAO.createCard(createCardDTO);
    }
}

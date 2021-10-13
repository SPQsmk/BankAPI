package com.bootcamp.service;

import com.bootcamp.dao.ClientDAO;
import com.bootcamp.dto.CardDTO;
import com.bootcamp.entity.Card;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public List<CardDTO> getCards(Long clientId) {
        List<Card> cards = clientDAO.getCards(clientId);
        List<CardDTO> res = new ArrayList<>();

        for (Card card : cards) {
            res.add(new CardDTO(card.getId(), card.getNumber()));
        }

        return res;
    }
}

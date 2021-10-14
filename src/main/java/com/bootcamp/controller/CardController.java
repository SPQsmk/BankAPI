package com.bootcamp.controller;

import com.bootcamp.dto.CreateCardDTO;
import com.bootcamp.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards/")
public class CardController {
    private final CardService cardService;
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public void createCard(@RequestBody CreateCardDTO createCardDTO) {
        logger.debug("CardController: call createCard, accountId: {}, cardNumber: {}", createCardDTO.getAccountId(), createCardDTO.getNumber());
        cardService.createCard(createCardDTO);
    }
}

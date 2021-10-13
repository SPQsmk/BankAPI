package com.bootcamp.controller;

import com.bootcamp.dto.CreateCardDTO;
import com.bootcamp.service.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards/")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create/")
    public void createCard(@RequestBody CreateCardDTO createCardDTO) {
        cardService.createCard(createCardDTO);
    }
}

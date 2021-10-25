package com.bootcamp.controller;

import com.bootcamp.dto.CardDTO;
import com.bootcamp.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    private final ClientService clientService;
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{userId}/cards")
    public ResponseEntity<List<CardDTO>> getCards(@PathVariable Long userId) {
        logger.debug("ClientController: call getCards, userId: {}", userId);
        return ResponseEntity.ok(clientService.getCards(userId));
    }
}

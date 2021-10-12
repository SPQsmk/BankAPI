package com.bootcamp.controller;

import com.bootcamp.entity.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
    @GetMapping
    public ResponseEntity<Card> getTodoList() {
        Card c = new Card();
        c.setId(1L);
        c.setNumber("12344321123443211234");
        return ResponseEntity.ok(c);
    }
}

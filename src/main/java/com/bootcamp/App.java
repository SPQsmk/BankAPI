package com.bootcamp;

import com.bootcamp.service.CardServiceImpl;

public class App {
    public static void main(String[] args) {
        CardServiceImpl service = CardServiceImpl.getInstance();
        service.getCards();
    }
}

package com.bootcamp.dao;

import com.bootcamp.exception.ClientNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientDAOExceptionTest {
    private final ClientDAO clientDAO;

    @Autowired
    public ClientDAOExceptionTest(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Test
    public void getCardsExceptionTest(){
        assertThrows(ClientNotFoundException.class, () -> clientDAO.getCards(100L));
    }
}

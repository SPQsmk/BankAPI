package com.bootcamp.dao;

import com.bootcamp.dto.CreateCardDTO;
import com.bootcamp.exception.NonUniqueCardException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CardDAOExceptionTest {
    private final CardDAO cardDAO;

    @Autowired
    public CardDAOExceptionTest(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Test
    public void createCardExceptionTest() {
        assertThrows(NonUniqueCardException.class, () -> cardDAO.createCard(new CreateCardDTO(1L, "5145671146971166")));
    }
}

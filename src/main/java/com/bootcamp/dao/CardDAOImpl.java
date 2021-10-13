package com.bootcamp.dao;

import com.bootcamp.dto.CreateCardDTO;
import com.bootcamp.entity.Account;
import com.bootcamp.entity.Card;
import com.bootcamp.exception.AccountNotFoundException;
import com.bootcamp.exception.NonUniqueCardException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class CardDAOImpl implements CardDAO{
    private final EntityManager entityManager;

    @Autowired
    public CardDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private boolean isCardExists(String cardNumber) {
        try {
            Card card = entityManager.createQuery("from Card where number=:number", Card.class)
                    .setParameter("number", cardNumber)
                    .getSingleResult();
        } catch (NoResultException e) {
            return false;
        }

        return true;
    }

    @Override
    public void createCard(CreateCardDTO createCardDTO) {
        String number = createCardDTO.getNumber();
        Long accountId = createCardDTO.getAccountId();

        Account account = entityManager.find(Account.class, accountId);

        if (account == null) {
            throw new AccountNotFoundException("Account with id: " + accountId + " not found");
        }

        if (isCardExists(number)) {
            throw new NonUniqueCardException("Card with number: " + number + " already exists");
        }

        Card card = new Card();
        card.setNumber(number);
        card.setAccount(account);

        entityManager.persist(card);
    }
}

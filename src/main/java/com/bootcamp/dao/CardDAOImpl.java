package com.bootcamp.dao;

import com.bootcamp.entity.Card;
import com.bootcamp.exception.NonUniqueCardException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CardDAOImpl implements CardDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCard(Card card) {
        if (entityManager.contains(card))
            throw new NonUniqueCardException("Card already exists");

        entityManager.persist(card);
    }
}

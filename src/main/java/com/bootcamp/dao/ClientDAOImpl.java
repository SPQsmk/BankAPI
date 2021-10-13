package com.bootcamp.dao;

import com.bootcamp.entity.Card;
import com.bootcamp.entity.Client;
import com.bootcamp.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {
    private final EntityManager entityManager;

    @Autowired
    public ClientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Card> getCards(Long clientId) {
        Client client = entityManager.find(Client.class, clientId);

        if (client == null) {
            throw new ClientNotFoundException("Client with id: " + clientId + " not found");
        }

        return entityManager
                .createQuery("from Card as c join fetch c.account as acc join fetch acc.client as cl where cl.id=:id", Card.class)
                .setParameter("id", clientId)
                .getResultList();
    }
}

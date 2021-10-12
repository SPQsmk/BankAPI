package com.bootcamp.dao;

import com.bootcamp.entity.Card;
import com.bootcamp.entity.Client;
import com.bootcamp.exception.NoSuchClientException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Card> getCards(Long clientId) {
        Client client = entityManager.find(Client.class, clientId);

        if (client == null) {
            throw new NoSuchClientException("Client not found");
        }

        return entityManager
                .createQuery("from Card as c join fetch c.account as acc join fetch acc.client as cl where cl.id=:id", Card.class)
                .setParameter("id", clientId)
                .getResultList();
    }
}

package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CardDAOImpl implements CardDAO{
    @PersistenceContext
    private EntityManager entityManager;
}

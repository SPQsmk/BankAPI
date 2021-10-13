package com.bootcamp.dao;

import com.bootcamp.entity.Account;
import com.bootcamp.exception.AccountNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private Account getAccount(Long accountId){
        Account account = entityManager.find(Account.class, accountId);

        if (account == null) {
            throw new AccountNotFoundException("Account with id: " + accountId + " not found");
        }

        return account;
    }

    @Override
    public BigDecimal getBalance(Long accountId) {
        return getAccount(accountId).getBalance();
    }

    @Override
    public void depositMoney(Long accountId, BigDecimal money) {
        Account account = getAccount(accountId);
        account.setBalance(account.getBalance().add(money));
    }
}

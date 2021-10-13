package com.bootcamp.dao;

import com.bootcamp.entity.Account;
import com.bootcamp.exception.AccountNotFoundException;
import com.bootcamp.exception.NegativeDepositException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private final EntityManager entityManager;

    @Autowired
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
        if (money.compareTo(BigDecimal.ZERO) <= 0)
            throw new NegativeDepositException("Negative deposit: " + money);

        Account account = getAccount(accountId);
        account.setBalance(account.getBalance().add(money));
    }
}

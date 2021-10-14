package com.bootcamp.dao;

import com.bootcamp.exception.AccountNotFoundException;
import com.bootcamp.exception.NegativeDepositException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AccountDAOExceptionTest {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountDAOExceptionTest(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Test
    public void getBalanceExceptionTest(){
        assertThrows(AccountNotFoundException.class, () -> accountDAO.getBalance(100L));
    }

    @Test
    public void depositMoneyExceptionTest(){
        assertThrows(NegativeDepositException.class, () -> accountDAO.depositMoney(1L, BigDecimal.valueOf(-100.0)));
    }
}

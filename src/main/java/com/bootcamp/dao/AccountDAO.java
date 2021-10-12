package com.bootcamp.dao;

import com.bootcamp.entity.Account;

import java.math.BigDecimal;

public interface AccountDAO {
    Account getAccount(Long accountId);
    BigDecimal getBalance(Long accountId);
    void depositMoney(Long accountId, BigDecimal money);
}

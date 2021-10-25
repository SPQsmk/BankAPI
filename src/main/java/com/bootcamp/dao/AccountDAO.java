package com.bootcamp.dao;

import java.math.BigDecimal;

public interface AccountDAO {
    /**
     * Get balance from DB by account id
     * @param accountId
     * @return balance
     */
    BigDecimal getBalance(Long accountId);

    /**
     * Depositing money into an account by account id in DB
     * @param accountId
     * @param money
     */
    void depositMoney(Long accountId, BigDecimal money);
}

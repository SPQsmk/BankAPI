package com.bootcamp.dao;

import java.math.BigDecimal;

public interface AccountDAO {
    BigDecimal getBalance(Long accountId);
    void depositMoney(Long accountId, BigDecimal money);
}

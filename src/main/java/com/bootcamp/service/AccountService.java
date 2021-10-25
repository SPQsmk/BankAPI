package com.bootcamp.service;

import com.bootcamp.dto.DepositDTO;
import com.bootcamp.dto.GetBalanceDTO;

public interface AccountService {
    /**
     * Get balance from datasource by account id
     * @param accountId
     * @return balance container
     */
    GetBalanceDTO getBalance(Long accountId);

    /**
     * Depositing money into an account by account id in datasource
     * @param depositDTO - contains account id and deposit amount
     */
    void depositMoney(DepositDTO depositDTO);
}

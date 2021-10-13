package com.bootcamp.service;

import com.bootcamp.dto.DepositDTO;
import com.bootcamp.dto.GetBalanceDTO;

public interface AccountService {
    GetBalanceDTO getBalance(Long accountId);
    void depositMoney(DepositDTO depositDTO);
}

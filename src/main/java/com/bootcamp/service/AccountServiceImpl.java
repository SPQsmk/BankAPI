package com.bootcamp.service;

import com.bootcamp.dao.AccountDAO;
import com.bootcamp.dto.DepositDTO;
import com.bootcamp.dto.GetBalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public GetBalanceDTO getBalance(Long accountId) {
        return new GetBalanceDTO(accountDAO.getBalance(accountId));
    }

    @Override
    @Transactional
    public void depositMoney(DepositDTO depositDTO) {
        accountDAO.depositMoney(depositDTO.getId(), depositDTO.getDeposit());
    }
}

package com.bootcamp.controller;

import com.bootcamp.dto.DepositDTO;
import com.bootcamp.dto.GetBalanceDTO;
import com.bootcamp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
    private final AccountService accountService;
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<GetBalanceDTO> getBalance(@PathVariable Long accountId) {
        logger.debug("AccountController: call getBalance, accountId: {}", accountId);
        return ResponseEntity.ok(accountService.getBalance(accountId));
    }

    @PutMapping("/update-balance")
    public void depositMoney(@RequestBody DepositDTO depositDTO) {
        logger.debug("AccountController : call depositMoney, accountId: {}, deposit: {}", depositDTO.getId(), depositDTO.getDeposit());
        accountService.depositMoney(depositDTO);
    }
}

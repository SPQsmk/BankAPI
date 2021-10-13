package com.bootcamp.controller;

import com.bootcamp.dto.DepositDTO;
import com.bootcamp.dto.GetBalanceDTO;
import com.bootcamp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<GetBalanceDTO> getBalance(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getBalance(accountId));
    }

    @PutMapping("/update-balance")
    public void depositMoney(@RequestBody DepositDTO depositDTO) {
        accountService.depositMoney(depositDTO);
    }
}

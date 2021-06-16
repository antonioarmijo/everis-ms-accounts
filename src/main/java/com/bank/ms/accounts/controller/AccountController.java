package com.bank.ms.accounts.controller;

import com.bank.ms.accounts.dto.AccountsBalanceDto;
import com.bank.ms.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/accounts/balance/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountsBalanceDto getAccountBalance(@PathVariable("personId") long personId){
        return accountService.getAccountsBalance(personId);
    }
}

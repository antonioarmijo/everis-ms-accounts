package com.bank.ms.accounts.controller;

import com.bank.ms.accounts.dto.AccountsBalanceDto;
import com.bank.ms.accounts.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @ApiOperation("Get balance of all client accouts and global balance")
    @ApiResponses(
            {
                    @ApiResponse(code=409,message = "Bussiness error"),
                    @ApiResponse(code=500,message = "Internal server error")
            }
    )
    @GetMapping(path = "/accounts/balance/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountsBalanceDto getAccountBalance(
            @ApiParam(name = "personId",value = "Client Id",example = "123")
            @PathVariable("personId") long personId){
                return accountService.getAccountsBalance(personId);
    }
}

package com.bank.ms.accounts.service;

import com.bank.ms.accounts.dto.AccountsBalanceDto;

public interface AccountService {
    AccountsBalanceDto getAccountsBalance(long personId);
}

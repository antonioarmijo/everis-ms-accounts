package com.bank.ms.accounts.repository;

import com.bank.ms.accounts.model.AccountModel;

import java.util.List;

public interface AccountRepository {
    List<AccountModel> findAccounts(long personId);
}

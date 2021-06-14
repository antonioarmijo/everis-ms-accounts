package com.bank.ms.accounts.service;

import com.bank.ms.accounts.dto.AccountBalanceDto;
import com.bank.ms.accounts.dto.AccountsBalanceDto;
import com.bank.ms.accounts.exception.BusinessException;
import com.bank.ms.accounts.model.AccountModel;
import com.bank.ms.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountsBalanceDto getAccountsBalance(long personId) {

        List<AccountModel> accountModels = accountRepository.findAccounts(personId);

        if(accountModels.isEmpty()){
            throw new BusinessException("ACC_NF","No accounts found for person id "+personId);
        }

        BigDecimal globalBalance = BigDecimal.ZERO;
        List<AccountBalanceDto> accountsBalanceDtos = new ArrayList<>();
        for(AccountModel accountModel: accountModels){
            globalBalance = globalBalance.add(accountModel.getBalance());
            accountsBalanceDtos.add(AccountBalanceDto.builder()
                    .number(accountModel.getNumber())
                    .balance(accountModel.getBalance())
                    .build());
        }
        return AccountsBalanceDto.builder()
                .globalBalance(globalBalance)
                .accounts(accountsBalanceDtos)
                .build();
    }

}

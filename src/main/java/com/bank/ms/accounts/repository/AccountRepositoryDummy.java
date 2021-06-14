package com.bank.ms.accounts.repository;

import com.bank.ms.accounts.model.AccountModel;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Repository
public class AccountRepositoryDummy implements AccountRepository{
    private final Map<Long,List<AccountModel>> clientAccountData = new HashMap<>();

    @PostConstruct
    public void init(){
        clientAccountData.put(123L, Arrays.asList(
                buildAccountModel(123L,"1001",BigDecimal.valueOf(1845.11)),
                buildAccountModel(123L,"1002",BigDecimal.valueOf(100.11))));

        clientAccountData.put(456L, Arrays.asList(
                buildAccountModel(456L,"4001",BigDecimal.valueOf(200.11)),
                buildAccountModel(456L,"4002",BigDecimal.valueOf(1629.82))));
    }

    private AccountModel buildAccountModel(long personId, String number, BigDecimal balance){
        AccountModel accountModel = new AccountModel();
        accountModel.setPersonId(personId);
        accountModel.setNumber(number);
        accountModel.setBalance(balance);
        return accountModel;
    }

    @Override
    public List<AccountModel> findAccounts(long personId) {
        List<AccountModel> result = clientAccountData.get(personId);
        if (result==null){
            result= new ArrayList<>();
        }
        return result;
    }
}

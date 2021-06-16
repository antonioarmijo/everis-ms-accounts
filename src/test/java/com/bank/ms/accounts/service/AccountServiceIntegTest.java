package com.bank.ms.accounts.service;

import com.bank.ms.accounts.MsAccountsApplication;
import com.bank.ms.accounts.dto.AccountBalanceDto;
import com.bank.ms.accounts.dto.AccountsBalanceDto;
import com.bank.ms.accounts.exception.BusinessException;
import com.bank.ms.accounts.model.AccountModel;
import com.bank.ms.accounts.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= MsAccountsApplication.class)
public class AccountServiceIntegTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository  accountRepository;

    @Test
    public void accoutsBalance_ok(){
        long personId=123;
        List<AccountModel> accountModels = accountRepository.findAccounts(personId);
        AccountsBalanceDto accountsBalance = accountService.getAccountsBalance(personId);

        Assertions.assertNotNull(accountsBalance);
        Assertions.assertNotNull(accountsBalance.getAccounts());
        Assertions.assertEquals(accountModels.size(),accountsBalance.getAccounts().size());

        BigDecimal expectedGlobalBalance = BigDecimal.ZERO;
        Iterator<AccountModel> itModel = accountModels.iterator();
        Iterator<AccountBalanceDto> itAcBal = accountsBalance.getAccounts().iterator();

        while (itModel.hasNext() && itAcBal.hasNext()){
            AccountModel accountModel = itModel.next();
            Assertions.assertEquals(accountModel.getPersonId(),personId);
            AccountBalanceDto accountBalanceDto = itAcBal.next();
            Assertions.assertEquals(accountModel.getNumber(),accountBalanceDto.getNumber());
            Assertions.assertEquals(accountModel.getBalance(),accountBalanceDto.getBalance());
            expectedGlobalBalance = expectedGlobalBalance.add(accountModel.getBalance());
        }
        Assertions.assertEquals(expectedGlobalBalance, accountsBalance.getGlobalBalance());
    }

    @Test
    public void accountBalance_empty(){
        BusinessException exception = Assertions.assertThrows(BusinessException.class,()->{
                long personId=234;
                accountService.getAccountsBalance(personId);
                }
        );
        String expectedCode="ACC_NF";
        String actualCode=exception.getCode();

        Assertions.assertEquals(expectedCode,actualCode);



    }
}

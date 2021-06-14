package com.bank.ms.accounts.service;

import com.bank.ms.accounts.dto.AccountBalanceDto;
import com.bank.ms.accounts.dto.AccountsBalanceDto;
import com.bank.ms.accounts.exception.BusinessException;
import com.bank.ms.accounts.model.AccountModel;
import com.bank.ms.accounts.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AccountServiceMockTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void accountsBalance_ok(){
        long personId= 1L;
        String accountNumber1= "1001";
        String accountNumber2= "1002";
        BigDecimal expectedBalance1  = BigDecimal.valueOf(100.11);
        BigDecimal expectedBalance2  = BigDecimal.valueOf(200.22);

        List<AccountModel> accountModels = new ArrayList();
        accountModels.add(buildAccountModel(personId,accountNumber1,expectedBalance1));
        accountModels.add(buildAccountModel(personId,accountNumber2,expectedBalance2));

        Mockito.when(accountRepository.findAccounts(personId)).thenReturn(accountModels);
        AccountsBalanceDto accountsBalance = accountService.getAccountsBalance(personId);

        Assertions.assertNotNull(accountsBalance);
        BigDecimal expectedGlobalBalance = expectedBalance1.add(expectedBalance2);
        Assertions.assertEquals(expectedGlobalBalance,accountsBalance.getGlobalBalance());
        Assertions.assertNotNull(accountsBalance.getAccounts());
        Assertions.assertEquals(accountModels.size(),accountsBalance.getAccounts().size());

        Iterator<AccountModel> itModel = accountModels.iterator();
        Iterator<AccountBalanceDto> itAcBal = accountsBalance.getAccounts().listIterator();
        while (itModel.hasNext() && itAcBal.hasNext()){
            AccountModel accountModel = itModel.next();
            Assertions.assertEquals(accountModel.getPersonId(),personId);
            AccountBalanceDto accountsBalanceDto = itAcBal.next();
            Assertions.assertEquals(accountModel.getNumber(),accountsBalanceDto.getNumber());
            Assertions.assertEquals(accountModel.getBalance(),accountsBalanceDto.getBalance());
        }
    }

    @Test
    public void accountsBalance_empty(){
        BusinessException exception = Assertions.assertThrows(BusinessException.class,() -> {
            long personId = 2;
            List<AccountModel> accountModels = new ArrayList();
            Mockito.when(accountRepository.findAccounts(personId)).thenReturn(accountModels);
            accountService.getAccountsBalance(personId);
        });
        String expectedCode = "ACC_NF";
        String actualCode = exception.getCode();
        Assertions.assertEquals(expectedCode,actualCode);
    }

    private AccountModel buildAccountModel(long personId, String accountNumber, BigDecimal balance){
        AccountModel account = new AccountModel();
        account.setPersonId(personId);
        account.setNumber(accountNumber);
        account.setBalance(balance);

        return account;
    }
}
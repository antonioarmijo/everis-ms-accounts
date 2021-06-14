package com.bank.ms.accounts.service;

import com.bank.ms.accounts.MsAccountsApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= MsAccountsApplication.class)
public class AccountServiceIntegTest {
    @Autowired
    private AccountService accountService;
}

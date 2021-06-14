package com.bank.ms.accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountModel {
    private long personId;
    private String number;
    private BigDecimal balance;
}

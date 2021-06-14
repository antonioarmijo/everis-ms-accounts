package com.bank.ms.accounts.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@ToString
@Builder
public class AccountBalanceDto {
    private String number;
    private BigDecimal balance;
}

package com.bank.ms.accounts.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class AccountsBalanceDto {
    private BigDecimal globalBalance;
    private List<AccountBalanceDto> accounts;
}

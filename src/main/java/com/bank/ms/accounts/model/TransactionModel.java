package com.bank.ms.accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class TransactionModel {
    private LocalDate date;
    private String comment;
    private TransactionType type;
    private BigDecimal amount;
}

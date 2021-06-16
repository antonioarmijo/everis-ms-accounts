package com.bank.ms.accounts.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.math.BigDecimal;

@ApiModel("Accout detail")
@Getter @Setter
@ToString
@Builder
public class AccountBalanceDto {
    @ApiModelProperty(value = "Account number",example = "123")
    private String number;
    @ApiModelProperty(value = "Account balance",example = "210.54")
    private BigDecimal balance;
}
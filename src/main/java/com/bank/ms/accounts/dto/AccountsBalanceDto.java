package com.bank.ms.accounts.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("All accounts balance")
@Getter @Setter
@ToString
@Builder
public class AccountsBalanceDto {
    @ApiModelProperty(value="Sum of all accounts balance", example = "210.54")
    private BigDecimal globalBalance;
    @ApiModelProperty("Accounts details")
    private List<AccountBalanceDto> accounts;
}

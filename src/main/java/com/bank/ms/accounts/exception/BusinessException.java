package com.bank.ms.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final String code;

    public BusinessException(String code, String message){
        super(message);
        Assert.notNull("code must not be null",code);
        this.code=code;
    }

    public String getCode(){
        return code;
    }
}

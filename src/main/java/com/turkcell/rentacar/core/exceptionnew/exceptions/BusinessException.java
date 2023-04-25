package com.turkcell.rentacar.core.exceptionnew.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}

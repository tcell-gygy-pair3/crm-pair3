package com.tcellpair3.cartservice.core.exceptions.type;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
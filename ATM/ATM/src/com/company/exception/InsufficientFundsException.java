package com.company.exception;

public class InsufficientFundsException extends Exception
{
    public InsufficientFundsException(String message){
        super(message);
    }
}

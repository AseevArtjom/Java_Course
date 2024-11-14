package com.company.exception;

public class BelowMinimumLimitException extends Exception
{
    public BelowMinimumLimitException(String message){
        super(message);
    }
}

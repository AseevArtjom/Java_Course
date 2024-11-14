package com.company.exception;

public class ExceedMaximumLimitException extends Exception
{
    public ExceedMaximumLimitException(String message){
        super(message);
    }
}

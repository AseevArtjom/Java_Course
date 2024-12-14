package org.example.exceptions;

public class ConnectionDBException extends Exception{
    public ConnectionDBException(String errorMessage) {
        super(errorMessage);
    }
}

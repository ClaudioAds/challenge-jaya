package com.jaya.moneyapi.config.handler;

public class InvalidCurrency extends RuntimeException{

    public InvalidCurrency(String message){
        super(message);
    }
}

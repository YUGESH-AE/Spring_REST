package com.example.spring_rest.exception;

public class NoSuchCustomer extends Exception{
    public NoSuchCustomer(String msg){
        super(msg);
    }
}

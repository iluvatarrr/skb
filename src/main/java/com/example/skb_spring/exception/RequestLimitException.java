package com.example.skb_spring.exception;

public class  RequestLimitException extends RuntimeException {
    public RequestLimitException(String message) { super(message); }
}

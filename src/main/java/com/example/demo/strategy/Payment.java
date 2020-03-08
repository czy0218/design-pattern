package com.example.demo.strategy;

/**
 * Created by czy0218 on 2020/3/8.
 */
public interface Payment {
    public PayState pay(String uid,double amount);
}

package com.example.demo.strategy;

import com.example.demo.strategy.type.AliPay;
import com.example.demo.strategy.type.JdPay;

/**
 * Created by czy0218 on 2020/3/8.
 */
public enum  PayType {

    ALI_PAY(new AliPay()),JD_PAY(new JdPay());

    private Payment payment;
    PayType(Payment payment){
        this.payment=payment;
    }
    public Payment get(){return this.payment;}
}

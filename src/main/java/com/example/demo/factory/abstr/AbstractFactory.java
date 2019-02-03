package com.example.demo.factory.abstr;

import com.example.demo.factory.Milk;

/**
 * Created by czy0218 on 2019/2/2.
 */
public abstract class AbstractFactory {
    public abstract Milk getTelunsu();

    abstract Milk getYili();

    abstract Milk getSalu();
}

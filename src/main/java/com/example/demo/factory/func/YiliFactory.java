package com.example.demo.factory.func;

import com.example.demo.factory.Milk;
import com.example.demo.factory.YiLi;

/**
 * Created by czy0218 on 2019/2/2.
 */
public class YiliFactory implements Factoty {
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}

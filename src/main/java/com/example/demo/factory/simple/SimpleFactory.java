package com.example.demo.factory.simple;

import com.example.demo.factory.Milk;
import com.example.demo.factory.TeLunSu;
import com.example.demo.factory.YiLi;

/**
 * Created by czy0218 on 2019/2/2.
 */
public class SimpleFactory {
    public Milk getMilk(String name) {
        if (name.equals("特仑苏")) {
            return new TeLunSu();
        } else if (name.equals("伊利")) {
            return new YiLi();
        } else {
            return null;
        }
    }
}

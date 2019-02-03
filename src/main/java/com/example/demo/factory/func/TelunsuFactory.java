package com.example.demo.factory.func;

import com.example.demo.factory.Milk;
import com.example.demo.factory.TeLunSu;

/**
 * Created by czy0218 on 2019/2/2.
 */
public class TelunsuFactory implements Factoty {
    @Override
    public Milk getMilk() {
        return new TeLunSu();
    }
}

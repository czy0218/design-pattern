package com.example.demo.factory.abstr;

import com.example.demo.factory.Milk;
import com.example.demo.factory.Salu;
import com.example.demo.factory.TeLunSu;
import com.example.demo.factory.YiLi;

/**
 * Created by czy0218 on 2019/2/2.
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        return new TeLunSu();
    }

    @Override
    public Milk getYili() {
        return new YiLi();
    }

    @Override
    public Milk getSalu() {
        return new Salu();
    }
}

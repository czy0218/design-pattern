package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by czy0218 on 2019/2/3.
 */
public class Meipo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("1111111111111");
        method.invoke(this.target, args);
        return null;
    }
}

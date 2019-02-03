package com.example.demo.sington;

/**
 * Created by czy0218 on 2019/2/2.
 *
 * 懒汉--
 *
 * 用到时才初始化--线程不安全
 */
public class LazyOne {
    private LazyOne() {
    }

    private static LazyOne lazyOne = null;

    public static synchronized LazyOne getLazyOne() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }

        return lazyOne;
    }
}

package com.example.demo.sington;

/**
 * Created by czy0218 on 2019/2/3.
 */
public class InnerClass {
    private InnerClass() {
    }

    public static final InnerClass getInnerClass() {
        return OutClass.INNER_CLASS;
    }

    private static class OutClass {
        private static final InnerClass INNER_CLASS = new InnerClass();
    }
}

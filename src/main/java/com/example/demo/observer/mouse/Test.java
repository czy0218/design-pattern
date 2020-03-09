package com.example.demo.observer.mouse;

import com.example.demo.observer.core.Event;

import java.lang.reflect.Method;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class Test {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        try {
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);


            Mouse mouse = new Mouse();

            mouse.addLisenter(MouseEventType.ON_CLICK, callback, onClick);
            mouse.click();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

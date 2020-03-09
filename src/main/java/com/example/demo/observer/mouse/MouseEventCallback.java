package com.example.demo.observer.mouse;

import com.example.demo.observer.core.Event;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class MouseEventCallback {
    public void onClick(Event e) {
        System.out.println("单机后触发");
        System.out.println("==单击事件==\n" + e);
    }

    public void onDoubleClick(Event e) {
        System.out.println("==双击事件==\n" + e);
    }
}

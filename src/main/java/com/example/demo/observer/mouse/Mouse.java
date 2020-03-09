package com.example.demo.observer.mouse;

import com.example.demo.observer.core.EventLisenter;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class Mouse extends EventLisenter{

    public void click(){
        System.out.println("单击");
        this.trigger(MouseEventType.ON_CLICK);
    }
    public void doubleClick(){
        System.out.println("双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }
}

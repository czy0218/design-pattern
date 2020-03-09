package com.example.demo.observer.core;

import java.lang.reflect.Method;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class Event {
    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\tsource=" + source +",\n"+
                "\ttarget=" + target +",\n"+
                "\tcallback=" + callback +",\n"+
                "\ttrigger='" + trigger + '\'' +",\n"+
                '}';
    }
}

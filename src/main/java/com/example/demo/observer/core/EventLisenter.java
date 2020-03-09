package com.example.demo.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class EventLisenter {
    Map<Enum, Event> events = new HashMap<>();

    public void addLisenter(Enum eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }

    private void trigger(Event e) {
        e.setSource(this);
        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }


}

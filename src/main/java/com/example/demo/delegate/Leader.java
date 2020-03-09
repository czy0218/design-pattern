package com.example.demo.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class Leader implements ITarget {

    private Map<String, ITarget> map = new HashMap<>();

    public Leader() {
        map.put("登录", new TargetA());
        map.put("注册", new TargetB());
    }

    @Override
    public void doing(String commond) {
        map.get(commond).doing(commond);
    }
}

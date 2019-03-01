package com.example.demo.algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: czy
 * @Date: 2019/2/28 15:52
 * @Version 1.0
 */
public class Distribution {

    /*
     * 随机分配
     */
    public static Map<String, List<String>> allotOfRandom(List<String> users, List<String> tasks) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                int r_user = new Random().nextInt(users.size());
                if (allot.containsKey(users.get(r_user))) {
                    List<String> list = allot.get(users.get(r_user));
                    list.add(tasks.get(i));
                    allot.put(users.get(r_user), list);
                } else {
                    List<String> list = new ArrayList<String>();
                    list.add(tasks.get(i));
                    allot.put(users.get(r_user), list);
                }
            }
        }
        return allot;
    }
    /*
     * 按批量平均分配
     */
    public static Map<String, List<String>> allotOfAverage1(List<String> users, List<List<String>> tasksList) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息

        if (users != null && users.size() > 0 && tasksList != null && tasksList.size() > 0) {
            for (int i = 0; i < tasksList.size(); i++) {
                if (tasksList.get(i) != null && tasksList.get(i).size() > 0) {
                    int j = i % users.size();
                    if (allot.containsKey(users.get(j))) {
                        List<String> list = allot.get(users.get(j));
                        tasksList.get(i).forEach(v -> list.add(v));
                        allot.put(users.get(j), list);
                    } else {
                        List<String> list = new ArrayList<String>();
                        tasksList.get(i).forEach(v -> list.add(v));
                        allot.put(users.get(j), list);
                    }
                }
            }
        }
        return allot;
    }
    /*
     * 权重分配
     */
    public static Map<String, List<String>> allotOfProportion(Map<String, String> users, List<String> tasks) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            int a = 0;//总权重
            for (Map.Entry<String, String> entry : users.entrySet()) {
                a += Integer.parseInt(entry.getValue());
            }
            int start = 0, end = 0;//起始下标 ,结束下标
            if (a > 0) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    List<String> allotTask = new ArrayList<String>();
                    end += Integer.parseInt(entry.getValue());//权重累计
                    for (; start < tasks.size() * end / a; start++) {
                        allotTask.add(tasks.get(start));
                    }
                    allot.put(entry.getKey(), allotTask);
                }
            }
        }
        return allot;
    }


    /*
     * 平均分配
     */
    public static Map<String, List<String>> allotOfAverage(List<String> users, List<String> tasks) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                int j = i % users.size();
                if (allot.containsKey(users.get(j))) {
                    List<String> list = allot.get(users.get(j));
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                } else {
                    List<String> list = new ArrayList<String>();
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                }
            }
        }
        return allot;
    }
    public static List<String> getTasks(List<String> list) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 3; j++) {
                stringList.add(list.get(i));
            }
        }
        return stringList;
    }
    /*
     * 全部分配
     * */
    public static Map<String, List<String>> allotOfAll(List<String> users, List<String> tasks) {
        Map<String, List<String>> map = new ConcurrentHashMap<String, List<String>>();
        users.forEach(v -> {
            List<String> list = new ArrayList();
            tasks.forEach(k -> {
                list.add(k);
            });
            map.put(v, list);
        });
        return map;
    }
}

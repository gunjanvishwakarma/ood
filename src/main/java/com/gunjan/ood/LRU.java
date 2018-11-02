package com.gunjan.ood;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
    private int capacity;
    private LinkedList<Integer> keys = new LinkedList<>();
    private Map<Integer,Integer> map = new HashMap<>();
    public LRU(int capacity) {
        this.capacity = capacity;
        keys.clear();
        map.clear();
    }
    
    public int get(int key) {
        Integer value =  map.get(key);
        if(value != null){
             keys.remove(keys.indexOf(key));
             keys.addFirst(key);
        }
        return value != null ? value : -1;
    }
    
    public void set(int key, int value) {
        map.put(key,value);
        if(keys.indexOf(key) != -1) keys.remove(keys.indexOf(key));
        keys.addFirst(key);
        if(map.size() > capacity){
            Integer last = keys.removeLast();
            map.remove(last);
        }
    }
}
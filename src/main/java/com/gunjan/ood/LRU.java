package com.gunjan.ood;

import java.util.HashMap;

public class LRU
{
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map = null;
    int capacity;
    
    public LRU(int capacity)
    {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key)
    {
        if(map.get(key) == null)
        {
            return -1;
        }
        //move to tail
        Node t = map.get(key);
        
        removeNode(t);
        addNode(t);
        
        return t.value;
    }
    
    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            Node t = map.get(key);
            t.value = value;
            
            //move to tail
            removeNode(t);
            addNode(t);
        }
        else
        {
            if(map.size() >= capacity)
            {
                //delete head
                map.remove(head.key);
                removeNode(head);
            }
            
            //add to tail
            Node node = new Node(key, value);
            addNode(node);
            map.put(key, node);
        }
    }
    
    private void removeNode(Node n)
    {
        if(n.prev != null)
        {
            n.prev.next = n.next;
        }
        else
        {
            head = n.next;
        }
        
        if(n.next != null)
        {
            n.next.prev = n.prev;
        }
        else
        {
            tail = n.prev;
        }
    }
    
    private void addNode(Node n)
    {
        if(tail != null)
        {
            tail.next = n;
        }
        
        n.prev = tail;
        n.next = null;
        tail = n;
        
        if(head == null)
        {
            head = tail;
        }
    }
}

class Node
{
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
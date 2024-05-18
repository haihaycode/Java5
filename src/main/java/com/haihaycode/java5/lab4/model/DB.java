package com.haihaycode.java5.lab4.model;

import java.util.HashMap;
import java.util.Map;

public class DB {
    public static Map<Integer, Item> items = new HashMap<>();
    static {
        items.put(1, new Item(1, "Samsung", 10.0, 0));
        items.put(2, new Item(2, "Nokia 2021", 20.50, 0));
        items.put(3, new Item(3, "iPhone 20", 90.49, 0));
        items.put(4, new Item(4, "Motorola", 15.55, 0));
        items.put(5, new Item(5, "Seamen", 8.99, 0));
    }
}

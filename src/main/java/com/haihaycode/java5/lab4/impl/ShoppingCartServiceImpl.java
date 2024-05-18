package com.haihaycode.java5.lab4.impl;

import com.haihaycode.java5.lab4.Service.ShoppingCartService;
import com.haihaycode.java5.lab4.model.DB;
import com.haihaycode.java5.lab4.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope

public class ShoppingCartServiceImpl  implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {

        Item item = map.get(id);
        if (item == null) {

            item = DB.items.get(id);
            item.setQty(1);
            map.put(id,item);
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }
    @Override
    public void remove(Integer id) {
        map.remove(id);

    }
    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if(item==null){
            item = DB.items.get(id);
            item.setQty(1);
            map.put(id,item);
        }else{
            item.setQty(qty);
        }
        return item;
    }
    @Override
    public void clear() {
        map.clear();
    }
    @Override
    public Collection<Item> getItems() {
        return map.values();
    }
    @Override
    public int getCount() {
        return map.values().size();
    }
    @Override
    public double getAmount() {
// TODO Auto-generated method stub
        return 0;
    }
}

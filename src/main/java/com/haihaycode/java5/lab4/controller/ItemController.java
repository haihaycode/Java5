package com.haihaycode.java5.lab4.controller;

import com.haihaycode.java5.lab4.Service.ShoppingCartService;
import com.haihaycode.java5.lab4.model.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ItemController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/item/index")
    public String list(Model model) {
        model.addAttribute("items", DB.items.values());
        return "lab4/item/index";
    }

    @ModelAttribute("totalItemsInCart")
    public int getCount(){
        return shoppingCartService.getCount();
    }

}

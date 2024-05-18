package com.haihaycode.java5.lab4.controller;

import com.haihaycode.java5.lab4.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingCartController {
    @Autowired
    ShoppingCartService cart;
    @GetMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "lab4/cart/index";
    }
   @GetMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view"; // hiển thị giỏ hàng
    }
    @GetMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }
    @GetMapping("/cart/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable int id, @RequestParam("qty") int qty) {
        cart.update(id,qty);
        return "redirect:/cart/view";
    }

}

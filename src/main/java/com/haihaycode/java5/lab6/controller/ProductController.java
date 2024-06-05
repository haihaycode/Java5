package com.haihaycode.java5.lab6.controller;

import com.haihaycode.java5.lab5.dao.ProductDAO;
import com.haihaycode.java5.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller("productControllerLab6")
public class ProductController {
    @Autowired
    ProductDAO dao;


    @GetMapping("/product/lab6/search")
    public String search(ModelMap model, @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);

        model.addAttribute("items", items);
        return "lab6/product/search";

    }
}

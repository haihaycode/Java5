package com.haihaycode.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    @GetMapping("/productForm")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "lab2/form_3";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product product) {
        productList.add(product);
        return "redirect:/productList";
    }
    @GetMapping("/productList")
    public String showProductList(Model model) {
        // Đưa danh sách sản phẩm vào model để hiển thị
        model.addAttribute("products", productList);
        return "lab2/form_3";
    }
}

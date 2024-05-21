package com.haihaycode.java5.lab5.controller;

import com.haihaycode.java5.lab5.dao.ProductDAO;
import com.haihaycode.java5.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController_lab5 {
    @Autowired
    ProductDAO productDAO;

    @GetMapping("/product/sort")
    public String sort(Model model,@RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        List<Product> items = productDAO.findAll(sort);
        model.addAttribute("items", items);
        return "lab5/product/sort";
    }
    @GetMapping("/product/page")
    public String paginate(Model model ,@RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 3);
        Page<Product> page = productDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "lab5/product/page";
    }
}

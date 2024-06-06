package com.haihaycode.java5.lab7.controller;


import com.haihaycode.java5.lab4.Service.SessionService;
import com.haihaycode.java5.lab5.dao.ProductDAO;
import com.haihaycode.java5.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class homeController {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    SessionService session;

    @GetMapping("/index")  public String index(Model model, @RequestParam("keywords") Optional<String> kw,
                                               @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse("");

        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        Page<Product> page = productDAO.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("kw", kwords);
        return "lab7/index";
    }
    @GetMapping("/about")  public String about() {   return "lab7/about";  }
}

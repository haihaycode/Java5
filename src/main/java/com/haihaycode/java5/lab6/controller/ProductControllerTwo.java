package com.haihaycode.java5.lab6.controller;

import com.haihaycode.java5.lab4.Service.SessionService;
import com.haihaycode.java5.lab5.dao.ProductDAO;
import com.haihaycode.java5.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller("productControllerLab6_2")
public class ProductControllerTwo {
    @Autowired
    SessionService session;
    @Autowired
    ProductDAO dao;

    @GetMapping("/product/search-and-page")
    public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords"));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        return "lab6/product/search-and-page";
    }

    @GetMapping("/product/createday")
    public String searchByCreateDate(Model model,
                                     @RequestParam("before") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> before,
                                     @RequestParam("after") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> after,
                                     @RequestParam("p") Optional<Integer> p) {
        Date beforeDate = before.orElse(new Date(Long.MIN_VALUE));
        Date afterDate = after.orElse(new Date());

        System.out.println("Before Date: " + beforeDate);
        System.out.println("After Date: " + afterDate);

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findByCreateDateBetween(beforeDate, afterDate, pageable);

        System.out.println("Total Elements: " + page.getTotalElements());

        model.addAttribute("page", page);
        return "lab6/product/search-and-page";
    }

}

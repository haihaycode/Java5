package com.haihaycode.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ParamController {
    @RequestMapping("/param/form")
    public String form() {
        return "lab2/form";
    }
    @RequestMapping("/param/save/{x}")
    public String save(@RequestParam String y , Model model, @PathVariable String x) {
        model.addAttribute("x",x);
        model.addAttribute("y",y);
        return "lab2/form";
    }
}

package com.haihaycode.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {

    @GetMapping("/ctrl/ok")
    public String ok() {
        return "lab2/ok";
    }

    @PostMapping("/ctrl/m1")
    public String m1(Model model) {
        model.addAttribute("result", "m1");
        return "lab2/ok";
    }

    @GetMapping("/ctrl/m2")
    public String m2(Model model) {
        model.addAttribute("result", "m2");
        return "lab2/ok";
    }

    @PostMapping(value = "/ctrl/m3" , params = "x")
    public String m3(Model model) {
        model.addAttribute("result", "m3");
        return "lab2/ok";
    }
}

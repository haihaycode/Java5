package com.haihaycode.java5.lab7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping("/index")  public String index() {   return "lab7/index";  }
    @GetMapping("/about")  public String about() {   return "lab7/about";  }
}

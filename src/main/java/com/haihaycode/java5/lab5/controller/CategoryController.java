package com.haihaycode.java5.lab5.controller;

import com.haihaycode.java5.lab5.dao.CategoryDAO;
import com.haihaycode.java5.lab5.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @GetMapping("/category/index")
    public String index(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = categoryDAO.findAll();
        model.addAttribute("items", items);
        return "lab5/index";
    }
    @PostMapping("/category/create")
    public String create(@ModelAttribute Category item) {
        categoryDAO.save(item);
        return "redirect:/category/index";
    }
    @GetMapping("/category/edit/{id}")
    public String edit(@PathVariable("id") String id , Model model ) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        if (optionalCategory.isPresent()) {
            Category item = optionalCategory.get();
            model.addAttribute("item", item);
            List<Category> items = categoryDAO.findAll();
            model.addAttribute("items", items);
            return "lab5/index";
        } else {
            return "redirect:/category/index";
        }
    }
    @PostMapping("/category/update")
    public String update(@ModelAttribute Category item) {
        categoryDAO.save(item);
        return "redirect:/category/edit/"+item.getId();
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        categoryDAO.deleteById(id);
        return "redirect:/category/index";
    }
}

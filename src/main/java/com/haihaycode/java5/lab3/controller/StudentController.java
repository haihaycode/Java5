package com.haihaycode.java5.lab3.controller;

import com.haihaycode.java5.lab3.model.Student;
import jakarta.servlet.ServletContext;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;



@Controller
public class StudentController {
    @Autowired
    ServletContext app;
    @Autowired
    HttpServletResponse response;


    @RequestMapping("/student/form")
    public String form(@ModelAttribute("sv") Student sv) {
        return "lab3/student/form";
    }


    @RequestMapping("/student/save")
    public String save(@Valid @ModelAttribute("sv") Student sv, BindingResult result,
                       @RequestParam("avatar") MultipartFile file, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message","Please fill out all required fields");
            model.addAttribute("messageType", "danger");
            return "lab3/student/form";
        }

        if (!file.isEmpty()) {
            try {
                String avatarFileName = file.getOriginalFilename();
                File docsDir = new File(app.getRealPath("/docs"));
                if (!docsDir.exists()) {
                    docsDir.mkdirs();
                }

                assert avatarFileName != null;
                File avatarFileLocation = new File(docsDir, avatarFileName);
                file.transferTo(avatarFileLocation);
                sv.setAvatarUrl("/docs/" + avatarFileName);
            } catch (IOException e) {

                model.addAttribute("message", "File upload failed!");
                model.addAttribute("messageType", "danger");
                return "lab3/student/form";
            }
        }

        model.addAttribute("message", "Student saved successfully!");
        model.addAttribute("messageType", "success");
        response.setCharacterEncoding("utf-8");
        return "lab3/student/form";
    }





    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "Female");
        return map;
    }
    @ModelAttribute("faculties")
    public Map<Integer, String> getFaculties() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Công Nghệ Thông tin");
        map.put(2, "Thiết kế đồ họa");
        return  map;
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
}

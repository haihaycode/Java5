package com.haihaycode.java5.lab4.controller;

import com.haihaycode.java5.lab4.Service.CookieService;
import com.haihaycode.java5.lab4.Service.ParamService;
import com.haihaycode.java5.lab4.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "lab4/account/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if (un.trim().equals("haipro1907") && pw.trim().equals("123")) {
            sessionService.set("username", un);
            if (rm) {
                cookieService.add("user", un, 10);
            }else{
                cookieService.remove("user");
            }
            model.addAttribute("message","Đăng nhập thành công ");
            System.out.println(rm);
        }else{
            model.addAttribute("message","Đăng nhập thất bại");
        }

        return "lab4/account/login";
    }

}

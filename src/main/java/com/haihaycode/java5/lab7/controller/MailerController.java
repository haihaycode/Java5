package com.haihaycode.java5.lab7.controller;


import com.haihaycode.java5.lab7.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailerController {
    @Autowired
    MailerService mailer;

    @GetMapping("/mail/demo")
    public String mail(Model model) {

        return "lab7/mail";

    }

    @PostMapping("/mail/test")
    public String demo(Model model, @RequestParam("to") String to, @RequestParam("subject") String subject,
                       @RequestParam("body") String body) {
        try {
            mailer.queue(to, subject, body);
            System.out.println("Xong");
            return "lab7/mail";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

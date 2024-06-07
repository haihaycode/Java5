package com.haihaycode.java5.lab7.controller;

import com.haihaycode.java5.lab4.Service.SessionService;
import com.haihaycode.java5.lab5.dao.AccountDAO;
import com.haihaycode.java5.lab5.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    SessionService sessionService;

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("user", new Account());
        return "lab7/register";
    }
    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute("user") Account user, Model model,RedirectAttributes redirectAttributes) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "lab7/register";
        }else{
            user.setActivated(true);
            user.setAdmin(false);
            accountDAO.save(user);
            redirectAttributes.addFlashAttribute("success", "Registration successful!");
            return "redirect:/login?success=Registration successful!"; // Redirect to the profile page
        }

    }
    @GetMapping("/login")
    public String loginGet(){
        return "lab7/login";
    }
    @PostMapping("/login")
    public ModelAndView loginPost(@RequestParam("username") String username,
                                  @RequestParam("password") String password, RedirectAttributes redirectAttributes){
        Account account =accountDAO.findByUsername(username);
        if (account == null) {
            ModelAndView mav = new ModelAndView("lab7/login");
            mav.addObject("error", "Account does not exist");
            return mav;
        } else {
            if (account.getPassword().equals(password)) {
                //setSession
                sessionService.set("user",account);
                redirectAttributes.addFlashAttribute("success","Đăng nhập thành công ");
                return new ModelAndView("redirect:/index"); // Chuyển hướng đến trang chủ hoặc trang khác
            } else {
                ModelAndView mav = new ModelAndView("lab7/login"); // Trở lại trang đăng nhập
                mav.addObject("error","Password is incorrect");
                return mav;
            }
        }

    }
    @GetMapping("/logout")
    public String logout(Model model,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Đăng xuất thành công ");
        sessionService.remove("user");
        return "redirect:/index?logout";
    }


    @GetMapping("/account")
    public String profileGet(Model model){
        Account account = sessionService.get("user");
        if(account!=null){
            Account user = accountDAO.findByUsername(account.getUsername());
            model.addAttribute("user", user);
        }
        return "lab7/profile";
    }
    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("user") Account user, Model model) {
        if (user != null) {
            accountDAO.save(user);
            model.addAttribute("success", "Your profile has been updated successfully.");
        } else {
            model.addAttribute("error", "Failed to update profile. Please try again.");
        }
        return "lab7/profile";
    }

}

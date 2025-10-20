package com.poly.lab8.controller;

import com.poly.lab8.entity.Account;
import com.poly.lab8.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpSession session,
                        @RequestParam String username,
                        @RequestParam String password) {
        Account user = accountService.login(username, password);
        if (user == null) {
            model.addAttribute("message", "Sai thông tin đăng nhập!");
            return "auth/login";
        }
        session.setAttribute("user", user);
        return "redirect:/mail/form";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}

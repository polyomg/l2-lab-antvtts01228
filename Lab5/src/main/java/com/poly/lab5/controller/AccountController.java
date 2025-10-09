package com.poly.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String loginForm() {
        return "account/login";
    }

    @PostMapping("/account/login")
    public String loginSubmit(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);

            if (remember) {
                cookieService.add("user", username, 10); // 10 ngày
            } else {
                cookieService.remove("user");
            }

            model.addAttribute("message", " Đăng nhập thành công!");
        } else {
            model.addAttribute("message", " Sai tên đăng nhập hoặc mật khẩu!");
        }

        return "account/login";
    }
}

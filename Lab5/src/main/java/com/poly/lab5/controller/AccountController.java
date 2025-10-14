package com.poly.lab5.controller;

import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String loginForm(Model model) {
        String savedUser = cookieService.getValue("user");
        if (savedUser != null) {
            model.addAttribute("username", savedUser);
            model.addAttribute("remember", true);
        }
        return "account/login";
    }

    @PostMapping("/account/login")
    public String loginSubmit(Model model, MultipartFile photo_file) {

        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        // Lưu ảnh (nếu có)
        String photoName = paramService.save(photo_file, "/uploads/");

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);
            if (remember) cookieService.add("user", username, 10);
            else cookieService.remove("user");

            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("photo", photoName);
        } else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
        }

        return "account/login";
    }
}

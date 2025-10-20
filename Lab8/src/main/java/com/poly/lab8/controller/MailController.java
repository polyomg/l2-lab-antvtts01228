package com.poly.lab8.controller;

import com.poly.lab8.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/form")
    public String mailForm() {
        return "mail/form";
    }

    @PostMapping("/send")
    public String sendMail(Model model,
                           @RequestParam String to,
                           @RequestParam String subject,
                           @RequestParam String body) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            mailService.send(mail);
            model.addAttribute("message", " Gửi mail thành công!");
        } catch (Exception e) {
            model.addAttribute("message", " Gửi mail thất bại: " + e.getMessage());
        }
        return "mail/form";
    }
}

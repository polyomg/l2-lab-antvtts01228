package com.poly.lab8.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    void send(SimpleMailMessage mail);
}

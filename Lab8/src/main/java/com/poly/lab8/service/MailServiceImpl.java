package com.poly.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    MailSender sender;

    @Override
    public void send(SimpleMailMessage mail) {
        sender.send(mail);
    }
}

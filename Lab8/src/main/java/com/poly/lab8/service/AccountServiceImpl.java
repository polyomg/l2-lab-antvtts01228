package com.poly.lab8.service;

import com.poly.lab8.entity.Account;
import com.poly.lab8.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repo;

    @Override
    public Account login(String username, String password) {
        Account acc = repo.findByUsername(username);
        if (acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }
}

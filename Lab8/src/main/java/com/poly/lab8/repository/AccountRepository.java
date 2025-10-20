package com.poly.lab8.repository;

import com.poly.lab8.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    private Map<String, Account> accounts = new HashMap<>();

    public AccountRepository() {
        accounts.put("poly", new Account("poly", "123", "poly@gmail.com"));
        accounts.put("admin", new Account("admin", "123", "admin@gmail.com"));
    }

    public Account findByUsername(String username) {
        return accounts.get(username);
    }
}

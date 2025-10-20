package com.poly.lab8.service;

import com.poly.lab8.entity.Account;

public interface AccountService {
    Account login(String username, String password);
}
